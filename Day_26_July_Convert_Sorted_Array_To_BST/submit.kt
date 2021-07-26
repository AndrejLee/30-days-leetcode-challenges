/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3827/
 * Convert Sorted Array To BST
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return convert(nums, 0, nums.size - 1)
    }

    fun convert(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val mid = start + (end - start) / 2
        val head = TreeNode(nums[mid])
        head.left = convert(nums, start, mid - 1)
        head.right = convert(nums, mid + 1, end)
        return head
    }
}