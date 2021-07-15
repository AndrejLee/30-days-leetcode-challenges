/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3815/
 * Valid Triangle Number
 * 2 Pointers
 */

class Solution {
    fun triangleNumber(nums: IntArray): Int {
        if (nums.size < 3) return 0
        nums.sort()
        var count = 0
        for (index in 2 until nums.size) {
            var start = 0
            var end = index - 1
            while (start < end) {
                if (nums[start] + nums[end] > nums[index]) {
                    count += (end - start)
                    end--
                } else {
                    start++
                }
            }
        }
        return count
    }
}