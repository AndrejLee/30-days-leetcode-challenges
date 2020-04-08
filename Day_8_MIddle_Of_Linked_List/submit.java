https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode middleNode = head;
        ListNode iterator =  head;
        
        int index = 1;
        while (iterator.next != null) {
            iterator = iterator.next;
            if (index++ % 2 != 0) {
                middleNode = middleNode.next;
            }
        }
        
        return middleNode;
    }
}
