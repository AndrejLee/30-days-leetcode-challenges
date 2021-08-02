/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3836/
 * Two Sum
 */

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, MutableList<Int>>()
        for ((index, num) in nums.withIndex()) {
            var cache = map[num]
            if (cache == null) cache = mutableListOf()
            cache.add(index)
            map[num] = cache
        }
        for ((index, num) in nums.withIndex()) {
            val theRest = target - num
            if (map.contains(theRest)) {
                if (map[theRest]!!.size > 1) return intArrayOf(index, map[theRest]!![1])
                else if (index != map[theRest]!![0]) return intArrayOf(index, map[theRest]!![0])
            }
        }
        return intArrayOf(-1,-1)
    }
}