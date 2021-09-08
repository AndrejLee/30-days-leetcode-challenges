/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3968/
 * Shifting Letters
 */

class Solution {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        var sum = 0L
        var ans = ""
        for (index in shifts.indices.reversed()) {
            sum = (sum.rem(26) + shifts[index].rem(26)).rem(26)
            ans += ((s[index] - 'a' + sum).rem(26) + 97).toChar()
        }
        return ans.reversed()
    }
}