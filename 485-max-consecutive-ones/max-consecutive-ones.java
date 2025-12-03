public class Solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;   // maximum consecutive 1's found
        int currentCount = 0; // current streak of 1's

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++; // increase streak
                maxCount = Math.max(maxCount, currentCount); // update max
            } else {
                currentCount = 0; // reset streak when 0 appears
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println("Max consecutive 1's: " + findMaxConsecutiveOnes(nums));
    }
}
