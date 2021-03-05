import java.util.Comparator;

public class BubbleSort {

    public static <E extends Comparable<E>> void sort(E[] list) {
        boolean proceed = true;
        for (int i = 1; i < list.length && proceed; i++) {
            proceed = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    proceed = true;
                }
            }
        }
    }

    public static <E> void sort(E[] list, Comparator<? super E> comparator) {
        boolean proceed = true;
        for (int i = 1; i < list.length && proceed; i++) {
            proceed = false;
            for (int j = 0; j < list.length - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    proceed = true;
                }
            }
        }
    }

}
