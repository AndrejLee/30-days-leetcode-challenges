https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/

class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
