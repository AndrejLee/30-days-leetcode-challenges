/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3905/
 * Sudoku Solver
 */

class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        doSolve(board, 0, 0)
    }

    fun doSolve(board: Array<CharArray>, i: Int, j: Int): Boolean {
        if (i == 9) return true
        val newI = if (j + 1 == 9) i + 1 else i
        val newJ = if (j + 1 == 9) 0 else j + 1
        return if (board[i][j] != '.') {
            doSolve(board, newI, newJ)
        } else {
            for (num in '1'..'9') {
                if (isValid(board, i, j, num)) {
                    board[i][j] = num
                    if (doSolve(board, newI, newJ)) return true
                    board[i][j] = '.'
                }
            }
            return false
        }
    }

    fun isValid(board: Array<CharArray>, row: Int, col: Int, target: Char): Boolean {
        val squareRowStart = 3 * (row / 3)
        val squareColStart = 3 * (col / 3)
        for (i in 0..8) {
            if (board[row][i] == target) return false
            if (board[i][col] == target) return false
            if (board[squareRowStart + i / 3][squareColStart + i.rem(3)] == target) return false
        }
        return true
    }
}