import kotlin.math.sqrt

/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3918/
 * Sum Of Square Numbers
 */

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        val sqrtC = sqrt(c.toDouble()).toInt()
        for (num in 0..sqrtC) {
            val bDouble: Double = sqrt((c - num * num).toDouble())
            if (bDouble == bDouble.toInt().toDouble())
                return true
        }

        return false
    }
}