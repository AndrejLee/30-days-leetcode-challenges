https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/

class Solution {
    public int maxSubArray(int[] nums) {
        return getMaxSubArray(nums, 0, nums.length - 1);
    }
    
    private int getMaxSubArray(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];
        
        int mid = (low + high) / 2;
        
        return max(getMaxSubArray(nums, low, mid),
                  getMaxSubArray(nums, mid + 1, high),
                  getMaxCrossSubArray(nums, low, mid, high));
    }
    
    private int getMaxCrossSubArray(int[] nums, int low, int mid, int high) { 
        int maxLeft = Integer.MIN_VALUE;
        int sumLeft = 0;
        for (int i = mid; i >= low; i--) {
            sumLeft += nums[i];
            if (maxLeft < sumLeft)
                maxLeft = sumLeft;
        }
        
        int maxRight = Integer.MIN_VALUE;
        int sumRight = 0;
        for (int i = mid + 1; i <= high; i++) {
            sumRight += nums[i];
            if (maxRight < sumRight)
                maxRight = sumRight;
        }
        
        return maxLeft + maxRight;
    }
    
    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    
    // KADANE'S ALGORITHM
    // public int maxSubArray(int[] nums) {
    //     int sum=0;
    //     int max=Integer.MIN_VALUE;
    //     int n=nums.length;
    //     for(int i=0;i<n;i++){
    //         sum+=nums[i];
    //         max=Math.max(max,sum);
    //         if(sum<0)
    //             sum=0;
    //     }
    //     return max;
    // }
}
