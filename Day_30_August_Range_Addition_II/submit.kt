/**
 * Link:  https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3957/
 * Range Addition II
 */

class Solution {
    fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
        val rows = Array(m) {0}
        val cols = Array(n) {0}
        for (op in ops) {
            val rowRange = op[0] - 1
            val colRange = op[1] - 1
            for (index in 0..rowRange)
                rows[index]++
            for (index in 0..colRange)
                cols[index]++
        }
        val max = rows[0]
        var countMaxInRows = 0
        for (value in rows) {
            if (value == max)
                countMaxInRows++
            else
                break
        }
        var countMaxInCols = 0
        for (value in cols) {
            if (value == max)
                countMaxInCols++
            else
                break
        }

        return countMaxInCols * countMaxInRows
    }
}