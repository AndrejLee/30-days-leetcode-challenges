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

/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3903/
 * Maximum Product Of Splitted Binary Tree
 */

class Solution {
    var total = 0L
    var ans = 0L
    val mod = 1000000007L

    fun maxProduct(root: TreeNode?): Int {
        getTotal(root)
        getAns(root)
        return ans.rem(mod).toInt()
    }

    fun getAns(root: TreeNode?): Long {
        if (root == null) return 0L

        val leftSum: Long = getAns(root.left)
        val rightSum: Long = getAns(root.right)

        ans = max(ans, (total - leftSum) * leftSum)
        ans = max(ans, (total - rightSum) * rightSum)

        return root.`val` + leftSum + rightSum
    }

    fun getTotal(root: TreeNode?) {
        if (root == null) return
        total += root.`val`
        getTotal(root.left)
        getTotal(root.right)
    }
}