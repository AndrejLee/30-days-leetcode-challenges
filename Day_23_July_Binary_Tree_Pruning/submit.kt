/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3824/
 * Binary Tree Pruning
 *
 */
class Solution {
    fun pruneTree(root: TreeNode?): TreeNode? {
        val res = doPrune(root)
        return if (res) root else null
    }

    fun doPrune(root: TreeNode?): Boolean {
        if (root == null) return false
        val leftRes = doPrune(root.left)
        val rightRes = doPrune(root.right)
        if (!leftRes) root.left = null
        if (!rightRes) root.right = null
        return leftRes || rightRes || root.`val` == 1
    }
}