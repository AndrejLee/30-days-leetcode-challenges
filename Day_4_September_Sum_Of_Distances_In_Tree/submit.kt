/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3963/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1443489/Sum-of-Distances-in-Tree-or-O(n)-Time-Complexity-Approach
 * Sum Of Distances In Tree
 */

class Solution {
    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val res = Array(n) {0}
        val count = Array(n) {1}
        val graph = Array(n) {HashSet<Int>()}
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        dfs(graph, res, count, 0, -1)
        dfs2(graph, res, count, n, 0, -1)
        return res.toIntArray()
    }

    fun dfs2(graph: Array<java.util.HashSet<Int>>, res: Array<Int>, count: Array<Int>, n: Int, node: Int, parent: Int) {
        for (child in graph[node]) {
            if (child != parent) {
                res[child] = res[node] - count[child] + n - count[child]
                dfs2(graph, res, count, n, child, node)
            }
        }
    }

    fun dfs(graph: Array<java.util.HashSet<Int>>, res: Array<Int>, count: Array<Int>, node: Int, parent: Int) {
        for (child in graph[node]) {
            if (child != parent) {
                dfs(graph, res, count, child, node)
                count[node] += count[child]
                res[node] += res[child] + count[child]
            }
        }
    }
}