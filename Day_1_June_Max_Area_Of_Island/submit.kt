/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3764/
 * Max Area of Island
 */

val X_DIRECTIONS = intArrayOf(0, 1, 0, -1)
val Y_DIRECTIONS = intArrayOf(-1, 0, 1, 0)

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val visited = Array(grid.size) {
        Array(grid[it].size) { false }
    }

    var maxArea = 0

    for (rowIndex in grid.indices) {
        for (columnIndex in grid[rowIndex].indices) {
            if (!visited[rowIndex][columnIndex] && grid[rowIndex][columnIndex] == 1) {
                maxArea = max(maxArea, getMaxAreaOfIsland(Pair(columnIndex, rowIndex), grid, visited))
            }
        }
    }

    return maxArea
}

fun getMaxAreaOfIsland(cell: Pair<Int, Int>, grid: Array<IntArray>, visited: Array<Array<Boolean>>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    visited[cell.second][cell.first] = true
    queue.add(cell)
    var result = 1

    while (queue.isNotEmpty()) {
        val currentCell = queue.remove()
        for (direction in X_DIRECTIONS.indices) {
            val columnIndex = currentCell.first + X_DIRECTIONS[direction]
            val rowIndex = currentCell.second + Y_DIRECTIONS[direction]
            if (isValid(rowIndex, columnIndex, grid) && !visited[rowIndex][columnIndex] && grid[rowIndex][columnIndex] == 1) {
                visited[rowIndex][columnIndex] = true
                queue.add(Pair(columnIndex, rowIndex))
                result++
            }
        }
    }
    return result
}

fun isValid(rowIndex: Int, columnIndex: Int, grid: Array<IntArray>): Boolean {
    return rowIndex >= 0 && rowIndex < grid.size && columnIndex >= 0 && columnIndex < grid[0].size
}