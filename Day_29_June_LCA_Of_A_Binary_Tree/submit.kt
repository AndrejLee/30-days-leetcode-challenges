/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/607/week-5-june-29th-june-30th/3797/
 * Lowest Common Ancestor of a Binary Tree
 */

class Solution {
    private var result: TreeNode? = null
    private var count = 0

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        findNode(root, p, q)

        return result
    }

    fun findNode(current: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
        if (current == null) return false


        val result1 = findNode(current.left, p, q)
        val result2 = findNode(current.right, p, q)
        var result3 = false
        if (current.`val` == p?.`val`) {
            count++
            result3 = true
        }
        if (current.`val` == q?.`val`) {
            count++
            result3 = true
        }

        if (result1 && result2 || result3 && result1 || result2 && result3)
            result = current
        return result1 || result2 || result3
    }
}