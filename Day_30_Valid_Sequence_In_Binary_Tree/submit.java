https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/

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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, 0, arr);
    }
    
    private boolean dfs(TreeNode node, int currentPos, int[] arr) {      
        if (currentPos == (arr.length - 1))
            return node != null && node.left == null && node.right == null && node.val == arr[currentPos];
        
        if (node == null)
            return false;
        
        if (node.val != arr[currentPos])
            return false;
        
        boolean left = dfs(node.left, currentPos + 1, arr);
        boolean right = dfs(node.right, currentPos + 1, arr);
        
        return left || right;
    }
}
