/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3904/
 * Valid Sudoku
 */

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowSets = Array(9) { HashSet<Char>() }
        val columnSets = Array(9) { HashSet<Char>() }
        val squareSets = Array(9) { HashSet<Char>() }

        for (i in board.indices) {
            for (j in board[0].indices) {
                val squareI = i / 3
                val squareJ = j / 3
                if (board[i][j] != '.') {
                    if (rowSets[i].contains(board[i][j])
                        || columnSets[j].contains(board[i][j])
                        || squareSets[3 * squareI + squareJ].contains(board[i][j]))
                        return false
                    rowSets[i].add(board[i][j])
                    columnSets[j].add(board[i][j])
                    squareSets[3 * squareI + squareJ].add(board[i][j])
                }
            }
        }
        return true
    }
}