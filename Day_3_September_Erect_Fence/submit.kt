/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3962/
 * Ref https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1442042/Erect-the-Fence-or-Convex-Hull-or-Jarvis-Algorithm-Simple-Explanation
 * Convex Hull
 * Erect Fence
 */

class Solution {
    fun crossProduct(p: IntArray, q: IntArray, r: IntArray): Int {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
    }

    fun isBetween(p: IntArray, i: IntArray, q: IntArray): Boolean {
        val a = i[0] >= p[0] && i[0] <= q[0] || i[0] >= q[0] && i[0] <= p[0]
        val b = i[1] >= p[1] && i[1] <= q[1] || i[1] >= q[1] && i[1] <= p[1]
        return a && b
    }

    fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
        val set = HashSet<IntArray>()
        if (trees.size < 4) {
            for (tree in trees) {
                set.add(tree)
            }
            return set.toTypedArray()
        }

        // Find left most
        var leftMost = 0
        for (index in trees.indices) {
            if (trees[index][0] < trees[leftMost][0])
                leftMost = index
        }

        // Start get boundaries
        var p = leftMost
        do {
            var q = (p + 1).rem(trees.size)

            // Find right most tree to q
            for (index in trees.indices) {
                if (crossProduct(trees[p], trees[index], trees[q]) < 0) {
                    q = index
                }
            }

            for (index in trees.indices) {
                if (index != p && index != q && crossProduct(trees[p], trees[index], trees[q]) == 0 && isBetween(trees[p], trees[index], trees[q])) {
                    set.add(trees[index])
                }
            }

            set.add(trees[q])
            p = q
        } while (p != leftMost)

        return set.toTypedArray()
    }
}