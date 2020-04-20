https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3305/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head = null;
        
        for (int i = 0; i < preorder.length; i++) {
            if (i == 0) {
                head = new TreeNode(preorder[i]); 
            } else {
                TreeNode node = new TreeNode(preorder[i]); 
                addNode(head, node);    
            }
        }
        
        return head;
    }
    
    private void addNode(TreeNode targetNode, TreeNode newNode) {
        if (newNode.val >= targetNode.val) {
            if (targetNode.right == null) {
                targetNode.right = newNode;
            } else {
                addNode(targetNode.right, newNode);
            }
        } else {
            if (targetNode.left == null) {
                targetNode.left = newNode;
            } else {
                addNode(targetNode.left, newNode);
            }
        }
    }
}
