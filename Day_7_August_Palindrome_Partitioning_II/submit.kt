import kotlin.math.min

/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3872/
 * Palindrome Partitioning II
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1388490/Palindrome-Partitioning-II-oror-DP-C%2B%2B-Solution-w-Approach
 */

class Solution {
    fun minCut(s: String): Int {
        val minCuts = Array(s.length) { it }
        for (index in 1 until s.length) {
            var movingIndex = 0
            // Odd length
            while (index - movingIndex >= 0 && index + movingIndex < s.length && s[index + movingIndex] == s[index - movingIndex]) {
                minCuts[index + movingIndex] = if (index - movingIndex == 0)
                    0
                else
                    min(minCuts[index + movingIndex], minCuts[index - movingIndex - 1] + 1)
                movingIndex++
            }
            movingIndex = 0
            // Even length
            while (index - movingIndex - 1 >= 0 && index + movingIndex < s.length && s[index + movingIndex] == s[index - movingIndex - 1]) {
                minCuts[index + movingIndex] = if (index - movingIndex - 1 == 0)
                    0
                else
                    min(minCuts[index + movingIndex], minCuts[index - movingIndex - 2] + 1)
                movingIndex++
            }
        }
        return minCuts[s.length - 1]
    }
}