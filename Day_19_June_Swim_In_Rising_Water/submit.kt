import kotlin.math.*

/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3785/
 * Swim in Rising Water
 */

class Solution {
    val X_DIRECTIONS = intArrayOf(0, 1, 0, -1)
    val Y_DIRECTIONS = intArrayOf(-1, 0, 1, 0)

    fun swimInWater(grid: Array<IntArray>): Int {
        return dijkstra(grid)
    }

    class Node(val index: Pair<Int, Int>, val dist: Int = 0): Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return dist.compareTo(other.dist)
        }
    }

    fun dijkstra(grid: Array<IntArray>): Int {
        var maxHeight = 0
        val queue = PriorityQueue<Node>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    queue.add(Node(Pair(i, j), 0))
                    grid[i][j] = -1
                    break
                }
            }
        }

        var targetCount = 0

        while (queue.isNotEmpty()) {
            val top = queue.poll()
            maxHeight = max(maxHeight, top.dist)
            if (top.index.first == 0 && top.index.second == 0) targetCount++
            if (top.index.first == grid.size - 1 && top.index.second == grid[0].size - 1) targetCount++

            if (targetCount == 2)
                break

            for (index in X_DIRECTIONS.indices) {
                val newX = top.index.first + X_DIRECTIONS[index]
                val newY = top.index.second + Y_DIRECTIONS[index]
                if (isValid(newX, newY, grid) && grid[newX][newY] != -1) {
                    queue.add(Node(Pair(newX, newY), grid[newX][newY]))
                    grid[newX][newY] = -1
                }
            }
        }

        return maxHeight
    }

    fun isValid(rowIndex: Int, columnIndex: Int, grid: Array<IntArray>): Boolean {
        return rowIndex >= 0 && rowIndex < grid.size && columnIndex >= 0 && columnIndex < grid[0].size
    }
}