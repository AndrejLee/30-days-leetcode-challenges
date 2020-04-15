https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int product = 1;
        res[0] = 1; 
        for (int i = 1; i < nums.length; ++i) {
            product *= nums[i - 1];
            res[i] = product;
        }
        
        product = 1;
        
        for (int i = nums.length - 2; i >= 0; --i) {
            product *= nums[i + 1];
            res[i] *= product;
        }
        
        return res;
    }
}
