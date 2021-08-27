import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3921/
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1428718/Longest-Uncommon-Subsequence-II-oror-2-Approach-w-explanation-oror-C%2B%2B-or-JAVA-or-Python3
 * Longest Uncommon Subsequence II
 */

class Solution {
    fun findLUSlength(strs: Array<String>): Int {
        var maxLen = -1
        for (i in strs.indices) {
            val curLen = strs[i].length
            var isNotSubSequence = true
            for (j in strs.indices) {
                if (i != j && checkSubSequence(strs[i], strs[j])) {
                    isNotSubSequence = false
                }
            }
            if (isNotSubSequence) {
                maxLen = max(maxLen, curLen)
            }
        }
        return maxLen
    }

    fun checkSubSequence(s: String, s1: String): Boolean {
        var i = 0
        var j = 0
        while (i < s.length && j < s1.length) {
            if (s[i] == s1[j])
                i++
            j++
        }
        return i == s.length
    }
}