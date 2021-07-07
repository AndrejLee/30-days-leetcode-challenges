/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3805/
 * Ref: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101
 * Kth Smallest Element in a Sorted Matrix
 */

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val m = matrix.size
        val n = matrix[0].size
        var left = matrix[0][0]
        var right = matrix[m - 1][n - 1]
        var ans = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (countElements(matrix, mid) >= k) {
                ans = mid
                right = mid - 1
            } else left = mid + 1
        }
        return ans
    }

    fun countElements(matrix: Array<IntArray>, mid: Int): Int {
        var count = 0
        var c = matrix[0].size - 1
        for (r in matrix.indices) {
            while (c >= 0 && matrix[r][c] > mid) c--
            count += c + 1
        }
        return count
    }
}