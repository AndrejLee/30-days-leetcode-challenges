/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3961/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1440511/JAVA-or-Generate-Binary-Search-Tree-or-Easy-0ms-or-AC
 * Unique Binary Search Tree II
 */
class Solution {
    fun generateTrees(n: Int): List<TreeNode?> {
        return helper(1, n)
    }

    fun helper(m: Int, n: Int): List<TreeNode?> {
        val res = ArrayList<TreeNode?>()
        if (m > n) {
            res.add(null)
            return res
        }
        for (i in m..n) {
            val lefts = helper(m, i - 1)
            val rights = helper(i + 1, n)
            for (left in lefts) {
                for (right in rights) {
                    val currentNode = TreeNode(i)
                    currentNode.left = left
                    currentNode.right = right
                    res.add(currentNode)
                }
            }
        }
        return res
    }
}