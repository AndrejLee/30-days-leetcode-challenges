/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3789/
 * Reverse Linked List II
 */
class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null)
            return head

        var newHead = head
        var leftNode = head

        val preLeftNode: ListNode? = moveToNode(leftNode, left)
        leftNode = preLeftNode?.next ?: leftNode

        val rightNode: ListNode? = if (left == right)
            leftNode
        else {
            val preRightNode = moveToNode(leftNode, right - left + 1)
            preRightNode?.next
        }

        if (left == 1)
            newHead = rightNode
        else
            preLeftNode?.next = rightNode

        val postRightNode: ListNode? = rightNode?.next
        rightNode?.next = null

        reversedList(leftNode)?.next = postRightNode

        return newHead
    }

    fun moveToNode(startNode: ListNode?, limit: Int): ListNode? {
        var currentNode = startNode
        var count = 1
        var preNode: ListNode? = null

        while (count < limit) {
            count++
            preNode = currentNode
            currentNode = currentNode?.next
        }
        return preNode
    }

    fun reversedList(head: ListNode?): ListNode? {
        head?.let {
            var current: ListNode? = it
            var pre: ListNode? = null

            while (current != null) {
                val tempCurrent = current.next
                current.next = pre
                pre = current
                current = tempCurrent
            }
        }

        return head
    }
}