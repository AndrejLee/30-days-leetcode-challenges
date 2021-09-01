import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/featured/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1438197/Array-Nesting-oror-W-O(N)-Approach-oror-C%2B%2B-or-JAVA-or-Python3
 * Array Nesting
 */

class Solution {
    fun arrayNesting(nums: IntArray): Int {
        var maxLen = 0
        val set = HashSet<Int>()

        for (index in nums.indices) {
            var currentValue = nums[index]
            var size = 0
            if (!set.contains(currentValue)) {
                while (!set.contains(currentValue)) {
                    set.add(currentValue)
                    currentValue = nums[currentValue]
                    size++
                }
            }

            maxLen = max(maxLen, size)
        }

        return maxLen
    }
}