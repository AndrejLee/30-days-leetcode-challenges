/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3803/
 * Reshape the Matrix
 */

class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val oldRowNum = mat.size
        val oldColNum = mat[0].size
        if (oldColNum * oldRowNum != r * c) return mat

        var rowIndex = 0
        var colIndex = 0
        val newMat = Array(r) { IntArray(c) }
        for (row in newMat.indices) {
            for (col in newMat[0].indices) {
                newMat[row][col] = mat[rowIndex][colIndex++]
                if (colIndex == oldColNum) {
                    rowIndex++
                    colIndex = 0
                }
            }
        }
        return newMat
    }
}