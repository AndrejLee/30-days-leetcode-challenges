import kotlin.math.max
import kotlin.math.min

/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3969/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1453718/Largest_Plus_Sign
 * Largest Plus Sign
 */

class Solution {
    fun orderOfLargestPlusSign(n: Int, mines: Array<IntArray>): Int {
        val left = Array(n) { Array(n) {1} }
        val up = Array(n) { Array(n) {1} }
        val down = Array(n) { Array(n) {1} }
        val right = Array(n) { Array(n) {1} }
        for (mine in mines) {
            left[mine[0]][mine[1]] = 0
            up[mine[0]][mine[1]] = 0
            down[mine[0]][mine[1]] = 0
            right[mine[0]][mine[1]] = 0
        }

        for (i in 1 until n) {
            for (j in 1 until n) {
                if (left[i][j] != 0) {
                    left[i][j] += left[i - 1][j]
                }
                if (up[i][j] != 0) {
                    up[i][j] += up[i][j - 1]
                }
            }
        }

        for (i in n - 2 downTo 0) {
            for (j in n - 2 downTo  0) {
                if (right[i][j] != 0) {
                    right[i][j] += right[i + 1][j]
                }
                if (down[i][j] != 0) {
                    down[i][j] += down[i][j + 1]
                }
            }
        }

        var ans = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                ans = max(ans, min(min(left[i][j], up[i][j]), min(down[i][j], right[i][j])))
            }
        }

        return ans
    }
}