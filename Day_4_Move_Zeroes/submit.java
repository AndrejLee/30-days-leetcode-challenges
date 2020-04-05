https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1)
            return;
        int iterator = 0;
        while (iterator < nums.length && nums[iterator] != 0) {
            ++iterator;
        }
        int nonZeroIndex = iterator++;
        while (iterator < nums.length) {
            if (nums[iterator] != 0) {
                swap(nums, nonZeroIndex, iterator);
                ++nonZeroIndex;
            }
            ++iterator;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
