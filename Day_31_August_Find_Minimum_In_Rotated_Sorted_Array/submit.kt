/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3958/
 * Find Minimum In Rotated Sorted Array
 */

class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (checkMin(nums, mid))
                return nums[mid]
            if (nums[mid] < nums[right])
                right = mid - 1
            else
                left = mid + 1
        }
        return 0
    }

    fun checkMin(nums: IntArray, mid: Int): Boolean {
        if (mid == 0) {
            if (nums[mid] < nums[mid + 1] && nums[mid] < nums.last())
                return true
        } else if (mid == nums.lastIndex) {
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums.first())
                return true
        } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
            return true
        }
        return false
    }
}