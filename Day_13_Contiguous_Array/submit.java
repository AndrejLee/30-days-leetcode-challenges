https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3298/

/*
    In this solution, I transform this problem to Find Sub-array with sum equals K Problem
    Ref: https://www.techiedelight.com/find-subarrays-given-sum-array/
    In this solution:
    + Target sum K is 0
    + For every 1 element, add 1 to current sum, for every 0 element, add -1 to current sum
    + In original problem, from indexes is store in a list but in this solution, if pairs of 0-1 are in a continous sequence
    we only need to store from index of the first pair. (First optimization)
    + Because of first optimization, so we don't really need a list of indexes in our map, just store the first index we got. (Second optimization)
*/

class Solution {
    public int findMaxLength(int[] nums) {        
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sumSoFar = 0;
        
        map.put(0, -1);
        
        for (int currentIndex = 0; currentIndex < nums.length; ++currentIndex) {
            sumSoFar += nums[currentIndex] == 1 ? 1 : -1;
            
            if (map.containsKey(sumSoFar)) {
                int fromIndex = map.get(sumSoFar);
                maxLength = Math.max(maxLength, currentIndex - fromIndex);
            } else {
                map.put(sumSoFar, currentIndex);
            }   
        }
        
        return maxLength;
    }
}
