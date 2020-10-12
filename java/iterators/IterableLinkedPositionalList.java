package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import lists.LinkedPositionalList;
import lists.Position;

public class IterableLinkedPositionalList<E> extends LinkedPositionalList<E> implements Iterable<E> {
    // ------ nested PositionIterator class ------------------
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first(); // position of the next element to report
        private Position<E> recent = null; // postion of the last reported element

        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null)
                throw new NoSuchElementException("nothing left");
            // store the cursor value in recent
            recent = cursor; // element at this position might later be removed
            cursor = after(cursor); // set the cursor to th next position
            return recent;
        }

        @Override
        public void remove() throws IllegalStateException {
            if (recent == null)
                throw new IllegalStateException("nothing to remove");
            IterableLinkedPositionalList.this.remove(recent); // remove from outer list
            recent = null; // do not allow remove again until next is called
            // Iterator.super.remove();
        }

    }
    // ------ end of nested PositionIterator class -------------------

    // --------- nested PostionIterable class -------------------------
    private class PositionIterable implements Iterable<Position<E>> {

        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }

    }

    // --------- end of nested PostionIterable class -------------------

    // ---------- nested ElementIterator class --------------------------
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement(); // return element
        }

        @Override
        public void remove() {
            posIterator.remove();
        }

    }
    // ---------- end of nested ElementIterator class --------------------------

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<E>> positions() {
        return new PositionIterable(); // create a new instance of the inner class
    }

}
