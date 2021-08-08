import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3874/
 * Rank Transform Of A Matrix
 * Ref: https://leetcode.com/problems/rank-transform-of-a-matrix/discuss/1391229/Java-solution-with-video-explanation-of-concept-%2B-some-thoughts
 */

class Solution {
    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
        val n = matrix.size
        val m = matrix[0].size
        val par = Array(n) {
                i -> Array(m) {
                j -> Pair(i, j)
        }
        }
        val rank = Array(n) {Array(m) {1} }
        val ans = Array(n) {IntArray(m) }

        val map = HashMap<Int, Pair<Int, Int>>()
        // row
        for (index in 0 until n) {
            map.clear()
            for (index1 in 0 until m) {
                if (map.contains(matrix[index][index1])) {
                    union(map[matrix[index][index1]]!!, par[index][index1], rank, par)
                } else {
                    map[matrix[index][index1]] = par[index][index1]
                }
            }
        }

        // column
        for (j in 0 until m) {
            map.clear()
            for (i in 0 until n) {
                if (map.contains(matrix[i][j])) {
                    union(map[matrix[i][j]]!!, par[i][j], rank, par)
                } else {
                    map[matrix[i][j]] = par[i][j]
                }
            }
        }

        val v = Array(n) {Array(m) {ArrayList<Pair<Int, Int>>()} }
        for (index in 0 until n) {
            for (index1 in 0 until m) {
                val parent = find(par[index][index1], par)
                v[parent.first][parent.second].add(Pair(index, index1))
            }
        }

        val treeMap = TreeMap<Int, ArrayList<ArrayList<Pair<Int, Int>>>>()
        for (index in 0 until n) {
            for (index1 in 0 until m) {
                val list = treeMap.getOrDefault(matrix[index][index1], ArrayList())
                list.add(v[index][index1])
                treeMap[matrix[index][index1]] = list
            }
        }

        val rows = Array(n) {0}
        val cols = Array(m) {0}

        for (entry in treeMap.entries) {
            val list = entry.value
            for (u in list) {
                var x = 0
                for (a in u) {
                    x = max(x, max(rows[a.first], cols[a.second]) + 1)
                }
                for (a in u) {
                    ans[a.first][a.second] = x
                    rows[a.first] = x
                    cols[a.second] = x
                }
            }
        }

        return ans
    }

    fun find(a: Pair<Int, Int>, par: Array<Array<Pair<Int, Int>>>): Pair<Int, Int> {
        val pair = par[a.first][a.second]
        if (pair.first == a.first && pair.second == a.second) return pair
        par[a.first][a.second] = find(par[a.first][a.second], par)
        return par[a.first][a.second]
    }

    fun union(a: Pair<Int, Int>, b: Pair<Int, Int>, rank: Array<Array<Int>>, par: Array<Array<Pair<Int, Int>>>) {
        val tempA = find(a, par)
        val tempB = find(b, par)

        if (rank[tempA.first][tempA.second] > rank[tempB.first][tempB.second]) {
            par[tempB.first][tempB.second] = tempA
        } else if (rank[tempB.first][tempB.second] > rank[tempA.first][tempA.second]) {
            par[tempA.first][tempA.second] = tempB
        } else {
            par[tempA.first][tempA.second] = tempB
            rank[tempB.first][tempB.second]++
        }
    }
}