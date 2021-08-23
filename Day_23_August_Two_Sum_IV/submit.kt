/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/
 * Two Sum IV
 */
class Solution {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val set = HashSet<Int>()
        return doCheck(root, k, set)
    }

    fun doCheck(node: TreeNode?, k: Int, set: java.util.HashSet<Int>): Boolean {
        if (node == null) return false
        if (set.contains(node.`val`)) return true
        set.add(k - node.`val`)
        val res1 = doCheck(node.left, k, set)
        val res2 = doCheck(node.right, k , set)
        return res1 || res2
    }
}