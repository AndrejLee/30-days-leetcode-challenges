/**
 *  Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3781/
 *
 */

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val ans = mutableListOf<String>()

        gen(0, 0, n, "", ans)

        return ans
    }

    fun gen(open: Int, close: Int, limit: Int, current: String, ans: MutableList<String>) {
        if (open == limit && close == limit) {
            ans.add(current)
            return
        }

        if (open < limit) {
            gen(open + 1, close,  limit, "$current(", ans)
        }
        if (close < limit && canPut("$current)")) {
            gen(open, close + 1, limit, "$current)", ans)
        }
    }

    fun canPut(s: String): Boolean {
        var count = 0
        for (char in s) {
            if (char == '(') count++
            else count--
            if (count < 0)
                return false
        }
        return true
    }
}