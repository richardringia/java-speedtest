public class Main {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        bubble();
        merge();
        quick();

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println("Total time: " + timeElapsed);
    }


    public static void bubble() {
        long start = System.currentTimeMillis();
        Integer[] list1 = GenerateList.generate();
        Integer[] list2 = GenerateList.generate();

        BubbleSort.sort(list1);
        BubbleSort.sort(list2, new IntegerComparator());
        long finish = System.currentTimeMillis();
        System.out.println("Bubble sort: " + (finish - start));
    }

    public static void merge() {
        long start = System.currentTimeMillis();

        Integer[] list1 = GenerateList.generate();
        Integer[] list2 = GenerateList.generate();

        MergeSort.sort(list1);
        MergeSort.sort(list2, new IntegerComparator());
        long finish = System.currentTimeMillis();
        System.out.println("Merge sort: " + (finish - start));
    }

    public static void quick() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            int[] list1 = GenerateList.generateIntArray();

            QuickSort.sort(list1, list1[0], list1[list1.length - 1]);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Quick sort: " + (finish - start));
    }

}
