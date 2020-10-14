package iterators;

import lists.Position;

/** Maintains a list of elements ordered with move-to-front heuristic. */
public class FavoritesListMTF<E> extends FavoritesList<E> {

    /** Moves accessed item at Position p to the front of the list. */
    @Override
    protected void moveUp(Position<Item<E>> p) {
        if (p != list.first()) {
            // the below line is only for demonstartion purpose only,
            // please comment this line whenever you use
            // System.out.println("Moving element " + value(p)
            //         + " to the front as it has been accessed recently & it is not at the front of the list.");
            list.addFirst(list.remove(p)); // remove and re-insert at the front of the list

        }

    }

    /**
     * Returns an iterable collection of the k most frequently accessed elements.
     */
    @Override
    public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if (k < 0 || k > size())
            throw new IllegalArgumentException("Invalid k");

        // we begin by making a copy of the original list
        PositionalList<Item<E>> temp = new LinkedPositionalList<>();
        for (Item<E> item : list)
            temp.addLast(item);

        // we repeatedly find, report and remove element with the largest access count
        PositionalList<E> result = new LinkedPositionalList<>();
        for (int j = 0; j < k; j++) {
            // intially consider first element as the most accessed element
            Position<Item<E>> highPos = temp.first();
            Position<Item<E>> walk = temp.after(highPos);
            while (walk != null) {
                if (count(walk) > count(highPos))
                    highPos = walk; // update the posistion of most accessed element
                walk = temp.after(walk); // set walk to the next position
            }
            // we have now found element with the highest access count
            result.addLast(value(highPos));
            temp.remove(highPos);
        }
        return result;
    }

}
