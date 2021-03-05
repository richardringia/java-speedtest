import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

    public static <E extends Comparable<E>> void sort(E[] list) {
        // If list > 1 then we can proceed
        if (list.length > 1) {

            // Create first split bij dividing the given list into 2
            E[] firstHalf = (E[])new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length /2);

            // recursively keep doing this until list.length <= 1
            sort(firstHalf);

            // Same as above but this time with the second half of the list
            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            sort(secondHalf);

            // merge and sort the halves until we have a fully sorted list
            merge(firstHalf, secondHalf, list);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
        int currentIndexOfList1 = 0;
        int currentIndexOfList2 = 0;
        int currentIndexOfList3 = 0;

        while (currentIndexOfList1 < list1.length && currentIndexOfList2 < list2.length) {
            if(list1[currentIndexOfList1].compareTo(list2[currentIndexOfList2]) < 0) {
                temp[currentIndexOfList3++] = list1[currentIndexOfList1++];
            } else {
                temp[currentIndexOfList3++] = list2[currentIndexOfList2++];
            }
        }

        while (currentIndexOfList1 < list1.length) temp[currentIndexOfList3++] = list1[currentIndexOfList1++];

        while (currentIndexOfList2 < list2.length) temp[currentIndexOfList3++] = list2[currentIndexOfList2++];
    }

    public static <E> void sort(E[] list, Comparator<? super E> comparator) {
        if (list.length > 1) {
            // Merge sort the first half
            E[] firstHalf = Arrays.copyOf(list, list.length / 2);
            sort(firstHalf, comparator);

            // Merge sort the second half
            E[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            sort(secondHalf, comparator);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list, comparator);
        }
    }

    public static <E> void merge(E[] list1, E[] list2, E[] temp, Comparator<? super E> comparator) {
        int currentIndexOfList1 = 0;
        int currentIndexOfList2 = 0;
        int currentIndexOfList3 = 0;

        while (currentIndexOfList1 < list1.length && currentIndexOfList2 < list2.length) {
            if (comparator.compare(list1[currentIndexOfList1], list2[currentIndexOfList2]) < 0)
                temp[currentIndexOfList3++] = list1[currentIndexOfList1++];
            else
                temp[currentIndexOfList3++] = list2[currentIndexOfList2++];
        }
        while (currentIndexOfList1 < list1.length) temp[currentIndexOfList3++] = list1[currentIndexOfList1++];
        while (currentIndexOfList2 < list2.length) temp[currentIndexOfList3++] = list2[currentIndexOfList2++];
    }

}
