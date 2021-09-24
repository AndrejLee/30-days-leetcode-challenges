/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3986/
 * Nth Tribonacci Number
 */

class Solution {
    fun tribonacci(n: Int): Int {
        val array = Array(n + 1) {0}
        if (n >= 1)
            array[1] = 1
        if (n >= 2)
            array[2] = 1
        for (index in 3..n) {
            array[index] = array[index - 3] + array[index - 2] + array[index - 1]
        }
        return array[n]
    }
}