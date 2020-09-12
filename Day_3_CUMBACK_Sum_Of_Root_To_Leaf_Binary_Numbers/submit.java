https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3453/

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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] res = new int[1];
        res[0] = 0;
        
        findPath(root, root.val, res);
        
        return res[0];
    }
    
    private void findPath(TreeNode node, int current, int[] res) {
        if (node.left == null && node.right == null) {
            res[0] += current;
            return;
        }
        
        if (node.left != null)
            findPath(node.left, (current << 1) + node.left.val, res);
        
        if (node.right != null)
            findPath(node.right, (current << 1) + node.right.val, res);
    }
}
