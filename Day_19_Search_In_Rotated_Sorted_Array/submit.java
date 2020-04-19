https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3304/

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (right >= left) {
            int mid = (right + left) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}
