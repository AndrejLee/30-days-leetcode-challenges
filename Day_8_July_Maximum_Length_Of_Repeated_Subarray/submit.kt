import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3807/
 * Maximum Length of Repeated Subarray
 */

class Solution {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val m = nums1.size
        val n = nums2.size
        val dp = Array(m + 1) { Array(n + 1) {0} }
        var ans = 0
        for (index1 in 1 until m + 1) {
            for (index2 in 1 until n + 1) {
                if (nums1[index1 - 1] == nums2[index2 - 1]) {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1] + 1
                    ans = max(ans, dp[index1][index2])
                }
            }
        }

        return ans
    }
}