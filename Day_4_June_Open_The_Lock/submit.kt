import kotlin.math.abs

/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3767/
 * Open The Lock
 */

const val NODE_COUNT = 10000

class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        val graph = mutableListOf<MutableList<Node>>()
        val start = 0
        val dist = Array(NODE_COUNT) {0}
        val deadEndsSet = HashSet<Int>()

        for (end in deadends) {
            deadEndsSet.add(end.toInt())
        }

        if (deadEndsSet.contains(start))
            return -1

        for (i in 0 until NODE_COUNT) {
            graph.add(mutableListOf())
            if (deadEndsSet.contains(i))
                continue
            val current = String.format("%04d",i)
            for (j in 0..3) {
                var upperChar = current[j] + 1
                if (upperChar > '9')
                    upperChar = '0'
                val upperString = StringBuilder(current).also { it.setCharAt(j, upperChar) }.toString()
                val upperNumber = upperString.toInt()
                if (!deadEndsSet.contains(upperNumber) && isEdge(current, upperString))
                    graph[i].add(Node(upperNumber, 1))

                var lowerChar = current[j] - 1
                if (lowerChar < '0')
                    lowerChar = '9'
                val lowerString = StringBuilder(current).also { it.setCharAt(j, lowerChar) }.toString()
                val lowerNumber = lowerString.toInt()
                if (!deadEndsSet.contains(lowerNumber) && isEdge(current, lowerString))
                    graph[i].add(Node(lowerNumber, 1))
            }
        }

        dijkstra(start, graph, dist)

        return if (dist[target.toInt()] == Int.MAX_VALUE) -1 else dist[target.toInt()]
    }

    fun dijkstra(start: Int, graph: MutableList<MutableList<Node>>, dist: Array<Int>) {
        val queue = PriorityQueue<Node>()
        for (i in 0 until NODE_COUNT) {
            dist[i] = Int.MAX_VALUE
        }
        queue.add(Node(start, 0))
        dist[start] = 0

        while (queue.isNotEmpty()) {
            val top = queue.poll()

            if (dist[top.value] != top.dist)
                continue

            for (i in 0 until graph[top.value].size) {
                val neighbor: Node = graph[top.value][i]
                if (top.dist + neighbor.dist < dist[neighbor.value]) {
                    dist[neighbor.value] = top.dist + neighbor.dist
                    queue.add(Node(neighbor.value, dist[neighbor.value]))
                }
            }
        }
    }

    fun isEdge(code1: String, code2: String): Boolean {
        val len = code1.length
        var differCount = 0
        var result = false
        for (i in 0 until len) {
            if (code1[i] != code2[i]) {
                differCount++
                val differDist = abs(code1[i] - code2[i])
                result = differDist == 1 || differDist == 9
            }

            if (differCount == 2)
                return false
        }

        return result
    }

    class Node(val value: Int, val dist: Int = 0): Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return dist.compareTo(other.dist)
        }
    }
}