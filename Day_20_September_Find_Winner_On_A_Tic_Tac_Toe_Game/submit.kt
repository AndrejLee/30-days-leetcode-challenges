/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3981/
 * Find Winner On A Tic Tac Toe Game
 */

class Solution {
    fun tictactoe(moves: Array<IntArray>): String {
        var current = 'x'
        val graph = Array(3) { Array(3) { ' ' } }
        for (move in moves) {
            graph[move[0]][move[1]] = current
            current = if (current == 'x') 'o' else 'x'
        }

        // check A
        var result = check(graph, 'x', "A")
        if (result.isNotEmpty())
            return result

        // check B
        result = check(graph, 'o', "B")
        if (result.isNotEmpty())
            return result

        return if (moves.size != graph.size * graph.size)
            "Pending"
        else
            "Draw"
    }

    fun check(graph: Array<Array<Char>>, c: Char, s: String): String {
        var count = 0
        for (i in graph.indices) {
            count = 0
            for (j in graph.indices) {
                if (graph[i][j] == c) count++
            }
            if (count == 3)
                return s
        }

        for (j in graph.indices) {
            count = 0
            for (i in graph.indices) {
                if (graph[i][j] == c) count++
            }
            if (count == 3)
                return s
        }

        count = 0
        for (i in graph.indices) {
            if (graph[i][i] == c)
                count++
        }
        if (count == 3)
            return s

        count = 0
        for (i in graph.indices) {
            if (graph[i][graph.size - 1 - i] == c)
                count++
        }
        if (count == 3)
            return s

        return ""
    }
}