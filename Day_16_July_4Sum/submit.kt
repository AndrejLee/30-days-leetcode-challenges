/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3816/
 * 4Sum
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1341164/4Sum-or-With-Explanation-and-Comments-or-C%2B%2B-or-Similar-to-3Sum-and-2Sum
 */

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4) return listOf()
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        var index1 = 0
        while (index1 < nums.size - 3) {
            var index2 = index1 + 1
            while (index2 < nums.size - 2) {
                val newTarget = target - nums[index1] - nums[index2]
                var start = index2 + 1
                var end = nums.size - 1
                while (start < end) {
                    when {
                        nums[start] + nums[end] == newTarget -> {
                            ans.add(listOf(nums[index1], nums[start], nums[end], nums[index2]))
                            val oldStart = nums[start]
                            while (start < end && nums[start] == oldStart) start++
                            val oldEnd = nums[end]
                            while (start < end &&  nums[end] == oldEnd) end--
                        }
                        nums[start] + nums[end] > newTarget -> {
                            end--
                        }
                        else -> start++
                    }
                }
                index2++
                while (index2 < nums.size && nums[index2] == nums[index2 - 1]) index2++
            }
            index1++
            while (index1 < nums.size && nums[index1] == nums[index1 - 1]) index1++
        }
        return ans
    }
}