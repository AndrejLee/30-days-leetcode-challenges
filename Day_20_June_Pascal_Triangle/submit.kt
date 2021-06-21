/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3786/
 * Pascal's Triangle
 */

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (size in 1..numRows) {
            val row = mutableListOf<Int>()
            row.add(1)
            if (size > 2) {
                for (index in 1..size - 2) {
                    row.add(result[size - 2][index] + result[size - 2][index - 1])
                }
            }
            if (size > 1)
                row.add(1)
            result.add(row)
        }
        return result
    }
}