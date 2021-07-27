import kotlin.math.abs

/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3828/
 * 3Sum Closet
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1365598/3Sum-Closest-oror-Easy-oror-W-Approach-oror-C%2B%2B-and-JAVA
 */

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var dif = Int.MAX_VALUE
        var ans = 0
        for (index in nums.indices) {
            var left = index + 1
            var right = nums.size - 1
            while (left < right) {
                val total = nums[left] + nums[right] + nums[index]
                val curDif = abs(total - target)
                if (curDif < dif) {
                    ans = total
                    dif = curDif
                }
                when {
                    total == target -> return target
                    total < target -> left++
                    else -> right--
                }
            }
        }
        return ans
    }
}