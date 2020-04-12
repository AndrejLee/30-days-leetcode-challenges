https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/

class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        
        while (n > 1) {
            if (stones[n - 1] != stones[n - 2]) {
                stones[n - 2] = stones[n - 1] - stones[n - 2];
                --n;
                Arrays.sort(stones, 0, n);
            } else {
                n -= 2;
            } 
        }
        
        if (n == 0)
            return 0;
        
        return stones[n - 1];
    }
}
