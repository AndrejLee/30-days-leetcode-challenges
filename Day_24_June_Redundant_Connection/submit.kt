/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3791/
 * Redundant Connection
 * Disjoint Set Union
 */

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = Array(edges.size + 1) { it }

        for (edge in edges) {
            if (find(parent, edge[0]) == find(parent, edge[1])) return edge
            union(parent, edge[0], edge[1])
        }
        return intArrayOf()
    }

    fun union(parent: Array<Int>, u: Int, v: Int) {
        parent[find(parent, u)] = find(parent, v)
    }

    fun find(parent: Array<Int>, u: Int): Int {
        var tempU = u
        while (tempU != parent[tempU]) {
            tempU = parent[tempU]
        }
        return tempU
    }
}