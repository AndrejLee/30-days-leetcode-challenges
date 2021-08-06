/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        iterateTree(root, ans, 1)
        return ans
    }

    fun iterateTree(root: Node?, ans: MutableList<MutableList<Int>>, level: Int) {
        if (root == null) return
        if (level > ans.size) {
            ans.add(mutableListOf())
        }
        ans[level - 1].add(root.`val`)
        for (child in root.children) {
            iterateTree(child, ans, level + 1)
        }
    }
}