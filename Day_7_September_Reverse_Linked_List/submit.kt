/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3966/
 * Reverse Linked List
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return head
        var currentHead = head
        var previous: ListNode? = null
        while (currentHead != null) {
            val next = currentHead.next
            currentHead.next = previous
            previous = currentHead
            currentHead = next
        }

        return previous
    }
}