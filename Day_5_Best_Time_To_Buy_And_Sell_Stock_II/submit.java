https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/

class Solution {
    public int maxProfit(int[] prices) {
        /*
        * This algorithm is about to add all ascendant sub array to result
        * because we want to buy at the lowest prices we and sell at the highest prices through time.
        */
        
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}
