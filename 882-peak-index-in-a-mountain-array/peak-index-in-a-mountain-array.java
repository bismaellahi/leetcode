public class Solution {
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is less than next element, peak is on the right side
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, peak is at mid or on the left side
                right = mid;
            }
        }

        // At the end, left == right, pointing to the peak index
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 5, 3, 1};
        System.out.println("Peak index: " + peakIndexInMountainArray(arr)); // Output: 3
    }
}
