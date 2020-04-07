https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/

class Solution {
    public int countElements(int[] arr) {
        Set<Integer> minimalSet = new HashSet<Integer>();
        
        for (int i = 0; i < arr.length; ++i) {
            minimalSet.add(arr[i]);
        }
        
        int result = 0;
        
        for (int i = 0; i < arr.length; ++i) {
            if (minimalSet.contains(arr[i] + 1)) {
                ++result;
            }
        }
        
        return result;
    }
}
