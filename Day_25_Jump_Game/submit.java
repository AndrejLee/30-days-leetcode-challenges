https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return false;
        
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == 0) {
                if (!reCheck(nums, i))
                    break;
            }
            i++;
        }
        return i == (nums.length - 1);
    }
    
    private boolean reCheck(int[] nums, int currentIndex) {
        int i = currentIndex - 1;
        
        while (i >= 0) {
            if (nums[i] > (currentIndex - i))
                return true;
            i--;
        }
        
        return false;
    }
}
