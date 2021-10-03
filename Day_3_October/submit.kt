import kotlin.math.max

/**
 * Link: https://leetcode.com/problems/jump-game/
 * Jump Game
 */

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxIndex = 0
        for ((index, num) in nums.withIndex()) {
            if (index > maxIndex)
                return false
            maxIndex = max(maxIndex, index + num)
            if (maxIndex >= nums.size - 1)
                return true
        }
        return false
    }
}