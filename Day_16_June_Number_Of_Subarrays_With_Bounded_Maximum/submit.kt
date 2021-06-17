/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3782/
 * Number of Subarrays with Bounded Maximum
 * Ref:
 * https://www.quora.com/How-do-you-find-the-number-of-subarrays
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/1278743
 * https://leetcode.com/discuss/explore/june-leetcoding-challenge-2021/1278431/Number-of-Subarrays-with-Bounded-Maximum-or-JS-Python-Java-C%2B%2B-or-Easy-Triang.-Number-Sol.-w-Expl.
 */

class Solution {
    fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
        return numOfSubArrays(nums, right) - numOfSubArrays(nums, left - 1)
    }

    fun numOfSubArrays(nums: IntArray, bound: Int): Int {
        var count = 0
        var total = 0
        for (num in nums) {
            if (num <= bound) count++ else count = 0
            total += count
        }
        return total
    }
}