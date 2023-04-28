package Q3;

public class QuickSorter {

    private int comparisons = 0;

    public int quicksortFirst(int[] array) {
        comparisons = 0;
        quicksortFirst(array, 0, array.length);
        return comparisons;
    }

    public int quicksortMedian(int[] array) {
        comparisons = 0;
        quicksortMedian(array, 0, array.length);
        return comparisons;
    }

    public int quicksortRandom(int[] array) {
        comparisons = 0;
        quicksortRandom(array, 0, array.length);
        return comparisons;
    }

    private void quicksortFirst(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quicksortFirst(array, left, pivot);
            quicksortFirst(array, pivot + 1, right);
        }
    }

    private void quicksortMedian(int[] array, int left, int right) {
        if (left < right) {
            int median = findMedian(array, left, right - 1);
//            Swap in order to use the first element as pivot
            swap(array, left, median);
            int pivot = partition(array, left, right);
            quicksortMedian(array, left, pivot);
            quicksortMedian(array, pivot + 1, right);
        }
    }

    private void quicksortRandom(int[] array, int left, int right) {
        if (left < right) {
            int random = (int) (Math.random() * (right - left) + left);
//            Swap in order to use the first element as pivot
            swap(array, left, random);
            int pivot = partition(array, left, right);
            quicksortRandom(array, left, pivot);
            quicksortRandom(array, pivot + 1, right);
        }
    }

    /**
     * Partition the subarray input_array[left_index ..< right_index]# around the value at left_index.
     *
     * @param input_array an input array
     * @param left_index  the index of the leftmost value (the pivot)
     * @param right_index one beyond the index of the rightmost value
     *
     * @return Index of the pivot after partitioning
     */
    private int partition(int[] input_array, int left_index, int right_index) {
        int pivot_value = input_array[left_index];

        int i = left_index + 1;
        for (int j = left_index + 1; j < right_index; j++) {
            comparisons++;
            if (input_array[j] < pivot_value) {
                swap(input_array, i, j);
                i++;
            }
        }
        swap(input_array, left_index, i - 1);
        return i - 1;
    }

    /**
     * Swap the values at the given indices in the given array.
     *
     * @param input_array an input array
     * @param left_index  the index of the first value
     * @param right_index the index of the second value
     */
    private void swap(int[] input_array, int left_index, int right_index) {
        int temp = input_array[left_index];
        input_array[left_index] = input_array[right_index];
        input_array[right_index] = temp;
    }

    private int findMedian(int[] array, int first, int last) {
        int middle = (first + last) / 2;
        int median;

//        If the middle value is larger than the smallest of the first and last,
//        and smaller than the largest of the first and last, it is the median.
        if (Math.min(array[first], array[last]) < array[middle] &&
                Math.max(array[first], array[last]) > array[middle]) {
            median = middle;
//            if the last value is larger than the smallest of the first and middle,
//            and smaller than the largest of the first and middle, it is the median.
        } else if (Math.min(array[first], array[middle]) < array[last] &&
                Math.max(array[first], array[middle]) > array[last]) {
            median = last;
//            Otherwise, the first value is the median.
        } else {
            median = first;
        }

        return median;
    }
}
