/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/
 * Path Sum II
 */
class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val ans = ArrayList<ArrayList<Int>>()
        if (root == null) return ans
        val current = ArrayList<Int>()
        doSum(root, targetSum - root.`val`, ans, current)
        return ans
    }

    fun doSum(root: TreeNode, targetSum: Int, ans: ArrayList<ArrayList<Int>>, current: ArrayList<Int>) {
        current.add(root.`val`)
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(current)
            }
            return
        }
        if (root.left != null)
            doSum(root.left!!, targetSum - root.left!!.`val`, ans, ArrayList(current))
        if (root.right != null)
            doSum(root.right!!, targetSum - root.right!!.`val`, ans, current)
    }
}