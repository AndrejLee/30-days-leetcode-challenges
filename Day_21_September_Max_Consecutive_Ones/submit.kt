import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3982/
 * Max Consecutive Ones
 */

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var count = 0
        var ans = 0
        for (num in nums) {
            if (num == 1) {
                count++
            } else {
                ans = max(ans, count)
                count = 0
            }
        }
        return max(ans, count)
    }
}