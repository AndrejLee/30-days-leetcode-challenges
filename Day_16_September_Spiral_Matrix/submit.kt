/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3977/
 * Spiral Matrix
 */

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty())
            return ArrayList()

        val direction = intArrayOf(0, 1)
        val currentCell = intArrayOf(0, 0)
        val total = matrix.size * matrix[0].size
        var count = 1
        val ans = ArrayList<Int>()
        var leftBound = -1
        var rightBound = matrix[0].size - 1
        var topBound = 0
        var bottomBound = matrix.size - 1
        while (count <= total) {
            ans.add(matrix[currentCell[0]][currentCell[1]])
            count++
            if (currentCell[0] == topBound && currentCell[1] == rightBound) {
                direction[0] = 1
                direction[1] = 0
                leftBound++
            } else if (currentCell[0] == bottomBound && currentCell[1] == rightBound) {
                direction[0] = 0
                direction[1] = -1
                topBound++
            } else if (currentCell[0] == bottomBound && currentCell[1] == leftBound) {
                direction[0] = -1
                direction[1] = 0
                rightBound--
            } else if (!(currentCell[0] == 0 && currentCell[1] == 0) && currentCell[0] == topBound && currentCell[1] == leftBound) {
                direction[0] = 0
                direction[1] = 1
                bottomBound--
            }

            currentCell[0] += direction[0]
            currentCell[1] += direction[1]
        }
        return ans
    }
}