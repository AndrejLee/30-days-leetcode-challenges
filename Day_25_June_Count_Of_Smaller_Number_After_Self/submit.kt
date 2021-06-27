/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3792/
 * Count of Smaller Numbers After Self
 */

class Solution {
    fun countSmaller(nums: IntArray): List<Int> {
        val res = Array(nums.size) { 0 }
        val sorted = mutableListOf<Int>()

        for ((index, num) in nums.withIndex().reversed()) {
            val sortedIndex = lowerBound(sorted, 0, sorted.size, num)
            sorted.add(sortedIndex, num)
            res[index] = sortedIndex
        }

        return res.toList()
    }

    fun lowerBound(a: List<Int>, left: Int, right: Int, x: Int): Int {
        var pos = right
        var tempRight = right
        var tempLeft = left
        while (tempLeft < tempRight) {
            val mid = tempLeft + (tempRight - tempLeft) / 2
            if (a[mid] >= x) {
                pos = mid
                tempRight = mid
            } else {
                tempLeft = mid + 1
            }
        }
        return pos
    }
}