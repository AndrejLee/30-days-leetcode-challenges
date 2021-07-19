/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        return doReverse(head, k)
    }

    fun doReverse(head: ListNode?, k: Int): ListNode? {
        if (head == null) return head
        var count = 0
        var tail = head
        while (count < k && tail != null) {
            count++
            tail = tail.next
        }

        if (count != k) return head

        var prev: ListNode? = null
        var current = head
        while (current != tail) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }
        head.next = doReverse(tail, k)

        return prev
    }
}