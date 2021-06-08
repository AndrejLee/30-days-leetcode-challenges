/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3772/
 * Construct Binary Tree from Preorder and Inorder Traversal
 */
class Solution {
    var preIndex = 0

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = HashMap<Int, Int>()
        for (i in inorder.indices) {
            map[inorder[i]] = i
        }
        return build(preorder, inorder, map, 0, preorder.size - 1)
    }

    fun build(preorder: IntArray, inorder: IntArray, map: HashMap<Int, Int>, inStart: Int, inEnd: Int): TreeNode? {
        if (inStart > inEnd)
            return null

        val currentValue = preorder[preIndex++]
        val node = TreeNode(currentValue)
        if (inStart == inEnd)
            return node

        var inIndex = map[currentValue]
        if (inIndex == null)
            inIndex = 0
        node.left = build(preorder, inorder, map, inStart = inStart, inEnd = inIndex - 1)
        node.right = build(preorder, inorder, map, inIndex + 1, inEnd)
        return node
    }
}