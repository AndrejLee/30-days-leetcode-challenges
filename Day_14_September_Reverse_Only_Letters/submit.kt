/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3974/
 * Reverse Only Letters
 */

class Solution {
    fun reverseOnlyLetters(s: String): String {
        var dash = 0
        var letter = s.length - 1
        val ans = StringBuilder()
        while (dash < s.length) {
            if (s[dash] >= 'a' && s[dash] <= 'z' || s[dash] >= 'A' && s[dash] <= 'Z') {
                if (s[letter] >= 'a' && s[letter] <= 'z' || s[letter] >= 'A' && s[letter] <= 'Z') {
                    ans.append(s[letter--])
                    dash++
                } else {
                    letter--
                }
            } else {
                ans.append(s[dash++])
            }
        }
        return ans.toString()
    }
}