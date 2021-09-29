/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3992/
 * Split Linked List In Parts
 */
class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val ans = Array<ListNode?>(k) { null }
        var nodeCount = 0
        var currentNode = head
        while (currentNode != null) {
            nodeCount++
            currentNode = currentNode.next
        }

        var size = if (nodeCount < k) {
            1
        } else {
            val extra = if (nodeCount.rem(k) == 0) 0 else 1
            nodeCount / k + extra
        }

        var currentHead = head
        var currentSize = size
        val remain = nodeCount.rem(k)
        for (index in ans.indices) {
            ans[index] = currentHead
            var node = currentHead
            for (count in 1 until currentSize) {
                node = node?.next
            }
            currentHead = node?.next
            node?.next = null
            currentSize = if (remain == 0 || index < remain - 1) size else size - 1
        }

        return ans
    }
}