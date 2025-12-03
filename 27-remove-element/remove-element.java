public class Solution {
    public static int removeElement(int[] nums, int val) {
        int k = 0; // Count of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move valid element to the front
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int k = removeElement(nums, val);

        System.out.println("k = " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
