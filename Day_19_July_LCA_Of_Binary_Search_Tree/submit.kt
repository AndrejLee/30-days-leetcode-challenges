/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var result: TreeNode? = null

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        findNode(root, p!!, q!!)

        return result
    }

    private fun findNode(current: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
        if (current == null) return false

        var result1 = false
        var result2 = false
        if (current.`val` < p.`val` && current.`val` < q.`val`) {
            result2 = findNode(current.right, p, q)
        } else if (current.`val` > p.`val` && current.`val` > q.`val`) {
            result1 = findNode(current.left, p, q)
        } else {
            result1 = findNode(current.left, p, q)
            result2 = findNode(current.right, p, q)
        }
        var result3 = false
        if (current.`val` == p.`val` || current.`val` == q.`val`) {
            result3 = true
        }

        if (result1 && result2 || result3 && result1 || result2 && result3)
            result = current
        return result1 || result2 || result3
    }
}