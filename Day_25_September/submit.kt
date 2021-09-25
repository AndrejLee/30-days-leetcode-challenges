import kotlin.math.min

/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3987/
 * Ref: https://www.tutorialspoint.com/shortest-path-in-a-grid-with-obstacles-elimination-in-cplusplus
 * Shortest Path In A Grid With Obstacles Elimination
 */


class Solution {
    val DIRECTION_X = intArrayOf(0, -1, 0, 1)
    val DIRECTION_Y = intArrayOf(-1, 0, 1, 0)

    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        var ans = Int.MAX_VALUE
        val queue = LinkedList<IntArray>()
        val visited = Array(grid.size) { Array(grid[0].size) { Array(k + 1) { Int.MAX_VALUE } } }
        queue.add(intArrayOf(0, 0, k, 0))
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current[0] == grid.size - 1 && current[1] == grid[0].size - 1)
                ans = min(ans, current[3])
            if (current[3] >= visited[current[0]][current[1]][current[2]])
                continue
            visited[current[0]][current[1]][current[2]] = current[3]
            for (index in DIRECTION_X.indices) {
                val nextX = current[0] + DIRECTION_X[index]
                val nextY = current[1] + DIRECTION_Y[index]
                if (isValid(nextX, nextY, grid) && current[3] + 1 < visited[nextX][nextY][current[2]]){
                    if (grid[nextX][nextY] == 0) {
                        queue.add(intArrayOf(nextX, nextY, current[2], current[3] + 1))
                    } else if (current[2] > 0) {
                        queue.add(intArrayOf(nextX, nextY, current[2] - 1, current[3] + 1))
                    }
                }
            }
        }
        if (ans == Int.MAX_VALUE)
            ans = -1
        return ans
    }

    fun isValid(nextX: Int, nextY: Int, grid: Array<IntArray>): Boolean {
        return nextX >= 0 && nextX < grid.size && nextY >= 0 && nextY < grid[0].size
    }
}