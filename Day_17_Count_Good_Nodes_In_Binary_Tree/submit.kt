/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

import kotlin.math.max

class Solution {
    var count = 0

    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0
        doFind(root, root.`val`)
        return count
    }

    fun doFind(root: TreeNode, currentMax: Int) {
        if (currentMax <= root.`val`) {
            count++
        }
        if (root.left != null) {
            doFind(root.left!!, max(currentMax, root.`val`))
        }
        if (root.right != null) {
            doFind(root.right!!, max(currentMax, root.`val`))
        }
    }
}