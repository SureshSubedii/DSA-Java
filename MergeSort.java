import java.util.Arrays;

public class MergeSort {
    public static int[] sortArray(int[] nums) {
        int midIndex = nums.length / 2;
        if (midIndex == 0)
            return nums;

        int[] left = sortArray(Arrays.copyOfRange(nums, 0, midIndex));
        int[] right = sortArray(Arrays.copyOfRange(nums, midIndex, nums.length));

        return mergeArrays(left, right);
    }

    public static int[] mergeArrays(int[] leftArray, int[] rightArray) {
        int left = 0, right = 0, index = 0;
        int[] sortedArray = new int[leftArray.length + rightArray.length];

        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left] <= rightArray[right]) {
                sortedArray[index++] = leftArray[left++];
            } else {
                sortedArray[index++] = rightArray[right++];
            }

        }
        while (left < leftArray.length) {
            sortedArray[index++] = leftArray[left++];
        }

        while (right < rightArray.length) {
            sortedArray[index++] = rightArray[right++];
        }
        return sortedArray;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 9, 3, 0, 2, 7, 1 };
        System.out.println(Arrays.toString(sortArray(nums)));

    }
}
