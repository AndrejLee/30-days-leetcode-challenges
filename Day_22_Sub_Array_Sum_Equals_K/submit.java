https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            } 
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }

        }
        
        return result;
    }
}
