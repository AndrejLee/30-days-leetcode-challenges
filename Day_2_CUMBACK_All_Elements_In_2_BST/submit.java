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
import java.util.*; 

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<Integer>();
        
        addElementsToList(list, root1);
        addElementsToList(list, root2);
        
        Collections.sort(list);
        
        return list;
    }
    
    private void addElementsToList(List<Integer> list, TreeNode node) {
        if (node == null)
            return;
        
        // Traverse like this to get result as a sorted list
        addElementsToList(list, node.left);
        list.add(node.val);
        addElementsToList(list, node.right);
    }
}
