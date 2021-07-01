import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/607/week-5-june-29th-june-30th/3796/
 * Max Consecutive Ones III
 */

class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var total = 0
        var max = 0
        var countZeros = 0
        for (index in nums.indices) {
            if (nums[index] == 0) {
                if (countZeros >= k) {
                    max = max(max, total)
                    // shrink window
                    while (nums[left++] == 1) {
                        total--
                    }
                    total--
                    countZeros--
                }
                countZeros++
            }
            // expand window
            total++
        }
        max = max(max, total)

        return max
    }
}