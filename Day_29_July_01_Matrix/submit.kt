/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3831/
 * 01 Matrix
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1370303/01-Matrix-Solution-or-BFS-Approach-or-Easy-Explained
 */

class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val m = mat[0].size
        val ans = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val queue = LinkedList<Pair<Int, Int>>()
        for (x in mat.indices) {
            for (y in mat[0].indices) {
                if (mat[x][y] == 0) {
                    ans[x][y] = 0
                    queue.push(Pair(x, y))
                }
            }
        }

        while (queue.isNotEmpty()) {
            val pair = queue.pop()
            val x = pair.first
            val y = pair.second
            if (x + 1 < n && ans[x + 1][y] > ans[x][y] + 1) {
                ans[x + 1][y] = ans[x][y] + 1
                queue.push(Pair(x + 1, y))
            }
            if (x - 1 >= 0 && ans[x - 1][y] > ans[x][y] + 1) {
                ans[x - 1][y] = ans[x][y] + 1
                queue.push(Pair(x - 1, y))
            }
            if (y + 1 < m && ans[x][y + 1] > ans[x][y] + 1) {
                ans[x][y + 1] = ans[x][y] + 1
                queue.push(Pair(x, y + 1))
            }
            if (y - 1 >= 0 && ans[x][y - 1] > ans[x][y] + 1) {
                ans[x][y - 1] = ans[x][y] + 1
                queue.push(Pair(x, y - 1))
            }
        }
        return ans
    }
}