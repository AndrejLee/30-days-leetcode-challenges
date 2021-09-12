/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3972/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1459255/Reachable-Nodes-In-Subdivided-Graph-or-Java-or-Graph-or-Dijkstra
 * Reachable Nodes In Subdivided Graph
 */

class Solution {
    fun reachableNodes(edges: Array<IntArray>, maxMoves: Int, n: Int): Int {
        val graph = Array(n) { HashMap<Int, Int>() }
        for (edge in edges) {
            graph[edge[0]][edge[1]] = edge[2]
            graph[edge[1]][edge[0]] = edge[2]
        }
        val visited = Array(n) {false}
        val queue = PriorityQueue<Pair<Int, Int>>(object : Comparator<Pair<Int, Int>> {
            override fun compare(o1: Pair<Int, Int>, o2: Pair<Int, Int>): Int {
                return o2.second.compareTo(o1.second)
            }

        })
        queue.add(Pair(0, maxMoves))
        var total = 1
        while (queue.isNotEmpty()) {
            val data = queue.remove()
            if (visited[data.first]) {
                total -= 1
                continue
            }
            visited[data.first] = true

            val nbrs = graph[data.first]
            for (node in nbrs.keys) {
                val remaining = nbrs[node]!!
                if (!visited[node] || remaining > 0) {
                    if (remaining <= data.second) {
                        if (remaining == data.second) total -= 1
                        total += remaining + 1
                        nbrs[node] = 0
                        graph[node][data.first] = 0
                    } else {
                        total += data.second
                        nbrs[node] = remaining - data.second
                        graph[node][data.first] = remaining - data.second
                    }
                    if (data.second - remaining - 1 >= 0)
                        queue.add(Pair(node, data.second - remaining - 1))
                }
            }
        }
        return total
    }
}