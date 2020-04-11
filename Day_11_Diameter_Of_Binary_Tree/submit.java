https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/

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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] currentMax = new int[1];
        currentMax[0] = Integer.MIN_VALUE;
        getMaxLength(root, currentMax);
        return currentMax[0];
    }
    
    private int getMaxLength(TreeNode node, int[] currentMax) {
        if (node == null)
            return -1;
        
        int maxLeft = getMaxLength(node.left, currentMax) + 1;
        int maxRight = getMaxLength(node.right, currentMax) + 1;
        
        currentMax[0] = Math.max(currentMax[0], maxLeft + maxRight);
        
        return Math.max(maxLeft, maxRight);
    }
}
