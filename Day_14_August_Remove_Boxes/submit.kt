import kotlin.math.max
/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3889/
 * Remove Boxes
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1402465/Remove-Boxes-oror-DP-w-Explanation-oror-C%2B%2B-or-Python-or-Java
 */

class Solution {
    fun removeBoxes(boxes: IntArray): Int {
        val dp = Array(100) { Array(100) { Array(100) {-1} } }
        return doDp(dp, boxes, 0, boxes.size - 1, 0)
    }

    fun doDp(dp: Array<Array<Array<Int>>>, boxes: IntArray, i: Int, j: Int, k: Int): Int {
        if (i > j) return 0
        if (dp[i][j][k] != -1) return dp[i][j][k]

        // Remove current box
        dp[i][j][k] = (k + 1) * (k + 1) + doDp(dp, boxes, i + 1, j, 0)

        // Find the same color box as ith box
        for (index in i + 1..j) {
            if (boxes[index] == boxes[i]) {
                dp[i][j][k] = max(dp[i][j][k], doDp(dp, boxes, i + 1, index - 1, 0) + doDp(dp, boxes, index, j, k + 1))
            }
        }
        return dp[i][j][k]
    }
}