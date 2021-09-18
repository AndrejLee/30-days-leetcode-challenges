/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3979/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1470400/Easy-explanation-oror-with-comments-oror-C%2B%2B
 * Expression Add Operators
 */

class Solution {
    fun addOperators(num: String, target: Int): List<String> {
        val ans = ArrayList<String>()

        var temp = 0L

        for (i in num.indices) {
            if (i > 0 && num[0] == '0')
                break

            temp = temp * 10 + (num[i] - '0')

            dfs(num, target.toLong(), ans, i + 1, num.substring(0, i + 1), temp, temp, 0)
        }

        return ans
    }

    fun dfs(num: String, target: Long, ans: ArrayList<String>, i: Int, currentString: String, value: Long, prevNum: Long, sign: Int) {
        if (i == num.length) {
            if (value == target)
                ans.add(currentString)
            return
        }

        var temp = 0L

        for (j in i until num.length) {
            if (j > i && num[i] == '0')
                break

            temp = temp * 10 + (num[j] - '0')

            // call for +
            dfs(num, target, ans, j + 1, "$currentString+$temp", value + temp, temp, 0)

            // call for -
            dfs(num, target, ans, j + 1, "$currentString-$temp", value - temp, temp, 1 )

            if (sign == 0) {
                dfs(num, target, ans, j + 1, "$currentString*$temp", value - prevNum + (prevNum * temp), (prevNum * temp), 0)
            } else {
                dfs(num, target, ans, j + 1, "$currentString*$temp", value + prevNum - (prevNum * temp), (prevNum * temp), 1)
            }
        }
    }
}