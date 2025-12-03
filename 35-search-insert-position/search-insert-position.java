public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow

            if (nums[mid] == target) {
                return mid; // target found
            } else if (nums[mid] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }

        // If not found, left will be the correct insert position
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("Index: " + searchInsert(nums, target)); // Output: 2

        target = 2;
        System.out.println("Index: " + searchInsert(nums, target)); // Output: 1

        target = 7;
        System.out.println("Index: " + searchInsert(nums, target)); // Output: 4

        target = 0;
        System.out.println("Index: " + searchInsert(nums, target)); // Output: 0
    }
}
