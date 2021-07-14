/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3813/
 * Custom Sort String
 */

class Solution {
    fun customSortString(order: String, str: String): String {
        val map = HashMap<Char, Int>()
        for ((index, char) in order.withIndex()) {
            map[char] = index
        }
        val arr= str.toCharArray()
        val res = arr.sortedWith(Comparator { o1: Char, o2: Char ->
            when {
                map[o1] == map[o2] -> 0
                map[o2] == null -> -1
                map[o1] == null -> 1
                map[o2]!! < map[o1]!! -> 1
                else -> -1
            }
        })
        return res.joinToString("")
    }
}