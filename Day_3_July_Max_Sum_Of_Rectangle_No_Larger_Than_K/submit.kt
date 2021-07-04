import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3801/
 * Max Sum Of Rectangle No Larger Than K
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1312803/Max-Sum-Of-Rectangle-oror-C%2B%2B-oror-explained
 */

class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        var total = Int.MIN_VALUE
        for (currentTopRow in matrix.indices) {
            val rowSum = Array(matrix[0].size) {0}
            for (row in currentTopRow until matrix.size) {
                for (col in matrix[0].indices) {
                    rowSum[col] += matrix[row][col]
                }
                total = max(total, findMaxSquare(rowSum, k))
            }
        }
        return total
    }

    fun findMaxSquare(rowSum: Array<Int>, k: Int): Int {
        val set = TreeSet<Int>()
        var currentSum = 0
        set.add(currentSum)
        var result = Int.MIN_VALUE
        for (sum in rowSum) {
            currentSum += sum
            val targetSum = set.ceiling(currentSum - k)
            if (targetSum != null) result = max(result, currentSum - targetSum)
            set.add(currentSum)
        }
        return result
    }
}