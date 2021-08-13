/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3888/
 * Set Matrix Zeroes
 */

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var rowZero = false
        var columnZero = false

        for (index in matrix[0].indices) {
            if (matrix[0][index] == 0) rowZero = true
        }

        for (index in matrix.indices) {
            if (matrix[index][0] == 0) columnZero = true
        }

        for (row in matrix.indices) {
            for (column in matrix[0].indices) {
                if (!isBound(row, column) && matrix[row][column] == 0) {
                    matrix[row][0] = 0
                    matrix[0][column] = 0
                }
            }
        }

        for (row in matrix.indices) {
            if (row != 0 && matrix[row][0] == 0) {
                for (column in matrix[0].indices) {
                    matrix[row][column] = 0
                }
            }
        }

        for (column in matrix[0].indices) {
            if (column != 0 && matrix[0][column] == 0) {
                for (row in matrix.indices) {
                    matrix[row][column] = 0
                }
            }
        }

        if (rowZero) {
            for (index in matrix[0].indices) {
                matrix[0][index] = 0
            }
        }

        if (columnZero) {
            for (index in matrix.indices) {
                matrix[index][0] = 0
            }
        }
    }

    fun isBound(row: Int, column: Int): Boolean {
        return row == 0 || column == 0
    }
}