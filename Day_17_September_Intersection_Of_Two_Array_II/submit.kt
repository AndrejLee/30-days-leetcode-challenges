/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3978/
 * Intersection of Two Array II
 */

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        for (num in nums1) {
            var count = map[num]
            if (count == null)
                count = 0
            map[num] = count + 1
        }

        val ans = ArrayList<Int>()
        for (num in nums2) {
            val count = map[num]
            if (count != null && count > 0) {
                ans.add(num)
                map[num] = count - 1
            }
        }
        return ans.toIntArray()
    }
}