/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3788/
 * Number of Matching Subsequences
 */

class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        var ans = 0
        val map = HashMap<Char, MutableList<Int>>()
        for ((index, char) in s.withIndex()) {
            if (!map.containsKey(char))
                map[char] = mutableListOf()
            map[char]!!.add(index)
        }

        for (word in words) {
            if (isSub(map, word))
                ans++
        }

        return ans
    }

    fun isSub(map: java.util.HashMap<Char, MutableList<Int>>, word: String): Boolean {
        var prePos = -1
        for (char in word) {
            if (!map.containsKey(char))
                return false

            val index = upperBound(map[char]!!, 0, map[char]!!.size, prePos)

            if (index == map[char]!!.size)
                return false

            prePos = map[char]!![index]
        }

        return true
    }

    fun upperBound(a: List<Int>, left: Int, right: Int, x: Int): Int {
        var pos = right
        var tempRight = right
        var tempLeft = left
        while (tempLeft < tempRight) {
            val mid = tempLeft + (tempRight - tempLeft) / 2
            if (a[mid] > x) {
                pos = mid
                tempRight = mid
            } else {
                tempLeft = mid + 1
            }
        }
        return pos
    }
}