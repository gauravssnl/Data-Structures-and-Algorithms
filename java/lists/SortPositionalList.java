package lists;

public class SortPosistionalList {
    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first(); // last position known to be sorted
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker); // set current pivot value to be next to the marker
            int value = pivot.getElement(); // number to be placed
            if (value > marker.getElement()) // pivot is already sorted
                marker = pivot; // update the marker
            else { // must relocate pivot
                Position<Integer> walk = marker; // find leftmost value greater than pivot
                while (walk != list.first() && list.before(walk).getElement() > value)
                    walk = list.before(walk); // move walk leftwards utill its element is bigger than pivot element
                list.remove(pivot); // remove pivot entry and
                list.addBefore(walk, value); // re-insert value in front of walk
            }
        }
    }

    public static void printPositionalListDetails(PositionalList<Integer> list) {
        Position<Integer> firstPosition = list.first();
        Position<Integer> lastPosition = list.last();
        Position<Integer> currentPosition = firstPosition;
        while (currentPosition != lastPosition) {
            System.out.println(currentPosition.getElement());
            currentPosition = list.after(currentPosition);
        }
    }

    public static void main(String[] args) {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        list.addFirst(50);
        list.addLast(10);
        list.addBefore(list.first(), 70);
        list.addBefore(list.last(), 7);
        list.addAfter(list.first(), 17);
        list.addAfter(list.last(), 5);
        printPositionalListDetails(list);
        insertionSort(list);
        System.out.println("Positional list after sorting");
        printPositionalListDetails(list);
    }
}
