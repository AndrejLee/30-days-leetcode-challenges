/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3811/
 * Isomorphic Strings
 */

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        if (!checkValid(s, t)) return false
        if (!checkValid(t, s)) return false
        return true
    }

    fun checkValid(s: String, t: String): Boolean {
        val map = HashMap<Char, Char>()
        for (index in s.indices) {
            val cache = map[s[index]]
            if (cache != null && cache != t[index]) return false
            map[s[index]] = t[index]
        }
        return true
    }
}