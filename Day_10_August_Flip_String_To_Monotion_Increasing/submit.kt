/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3876/
 * Flip String to Monotone Increasing
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1394664/Flip-String-to-Monotone-Increasing-oror-Basic-Implementation-wo-DP-oror-C%2B%2B-or-Python-or-Java
 */

class Solution {
    fun minFlipsMonoIncr(s: String): Int {
        var flipCount = 0
        var oneCount = 0
        for (char in s) {
            if (char == '0') {
                if (oneCount > 0) flipCount++
            } else {
                oneCount++
            }

            if (oneCount < flipCount)
                flipCount = oneCount
        }

        return flipCount
    }
}