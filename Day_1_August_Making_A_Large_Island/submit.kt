import kotlin.math.max
/**
 * Link: https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/
 * Making A Large Island
 */

class Solution {
    var maxArea = 0
    val map = HashMap<Int, Int>()
    val directions = arrayOf(Pair(-1, 0), Pair(0, -1), Pair(1, 0), Pair(0, 1))
    val queue0 = LinkedList<Pair<Int, Int>>()

    fun largestIsland(grid: Array<IntArray>): Int {
        calculateConnectedRegionSize(grid)
        doFlip(grid)
        return maxArea
    }

    fun doFlip(grid: Array<IntArray>) {
        val set = HashSet<Int>()
        while (queue0.isNotEmpty()) {
            val current = queue0.poll()
            var currentSize = 0
            set.clear()
            for (dir in directions) {
                val newI = current.first + dir.first
                val newJ = current.second + dir.second
                if (isValid(newI, newJ, grid) && grid[newI][newJ] != 0 && !set.contains(grid[newI][newJ])) {
                    set.add(grid[newI][newJ])
                    currentSize += map[grid[newI][newJ]]!!
                }
            }
            maxArea = max(maxArea, currentSize + 1)
        }
    }

    fun calculateConnectedRegionSize(grid: Array<IntArray>) {
        var index = 2
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    map[index] = 0
                    dfs(i, j, grid, index)
                    maxArea = max(maxArea, map[index]!!)
                    index++
                }
                if (grid[i][j] == 0) {
                    queue0.push(Pair(i, j))
                }
            }
        }
    }

    fun dfs(i: Int, j: Int, grid: Array<IntArray>, index: Int) {
        grid[i][j] = index
        val current = map[index]!!
        map[index] = current + 1
        for (dir in directions) {
            val newI = i + dir.first
            val newJ = j + dir.second
            if (isValid(newI, newJ, grid) && grid[newI][newJ] == 1) {
                dfs(newI, newJ, grid, index)
            }
        }
    }

    fun isValid(newI: Int, newJ: Int, grid: Array<IntArray>): Boolean {
        return newI >= 0 && newI < grid.size && newJ >= 0 && newJ < grid[0].size
    }
}