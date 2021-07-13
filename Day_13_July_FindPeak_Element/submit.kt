/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3812/
 * Find Peak Element
 */

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var left = 0
        var right = nums.size - 1
        if (nums[left + 1] < nums[left]) return left
        if (nums[right - 1] < nums[right]) return right
        while (left < right) {
            val mid = left + (right - left) / 2
            if ((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && (mid + 1 == nums.size || nums[mid] > nums[mid + 1])) return mid
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1
            } else
                right = mid - 1
        }
        return left
    }
}