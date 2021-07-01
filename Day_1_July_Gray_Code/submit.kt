/**
 * Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3799/
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1308587/Gray-Code-or-Recursion-%2B-Iterative-wExplanation
 * Gray Code
 */

class Solution {
    fun grayCode(n: Int): List<Int> {
        val res = mutableListOf<Int>()
        for (number in 0 until (1 shl n)) {
            res.add(number xor (number shr 1))
        }
        return res
    }
}