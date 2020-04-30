https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3314/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private int findMax(TreeNode node, int[] currentMax) {
        if (node == null)
            return 0;
        
        int maxLeft = findMax(node.left, currentMax);
        int maxRight = findMax(node.right, currentMax);
        
        int temp1 = Math.max(maxLeft, maxRight);
        temp1 = Math.max(temp1, 0);
        
        int temp = Math.max(temp1, maxLeft + maxRight);
        currentMax[0] = Math.max(currentMax[0], temp + node.val);
        
        return temp1 + node.val;
    }
    
    public int maxPathSum(TreeNode root) {        
        int[] currentMax = new int[1];
        currentMax[0] = Integer.MIN_VALUE;
        findMax(root, currentMax);
        return currentMax[0];
    }
}
