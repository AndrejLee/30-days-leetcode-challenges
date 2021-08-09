/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3875/
 * Add Strings
 */

class Solution {
    fun addStrings(num1: String, num2: String): String {
        if (num1 == "0") return num2
        if (num2 == "0") return num1

        var ans = ""
        var currentIndex = 0
        var rem = 0
        val reverseNum1 = num1.reversed()
        val reverseNum2 = num2.reversed()

        while (currentIndex < num1.length || currentIndex < num2.length) {
            val digit1 = if (currentIndex < num1.length) reverseNum1[currentIndex].toString().toInt() else 0
            val digit2 = if (currentIndex < num2.length) reverseNum2[currentIndex].toString().toInt() else 0
            val sum = digit1 + digit2
            ans += (rem + sum).rem(10)
            rem = (rem + sum) / 10
            currentIndex++
        }

        if (rem != 0) ans += rem

        return ans.reversed()
    }

}