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

//https://leetcode.com/problems/diameter-of-binary-tree/ 
//recursively traverse, the answer lies in the subtree with the greatest depth
//does that sound confusing? ...
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        recurse(root);
        return ans;
    } 
    public int recurse(TreeNode cur){
        if (cur == null){
            return 0;
        }
        int leftdepth = recurse(cur.left);
        int rightdepth = recurse(cur.right);
        if (leftdepth + rightdepth > ans){
            ans = leftdepth + rightdepth;
        }
        if (leftdepth > rightdepth){
            return 1 + leftdepth;
        } else {
            return 1 + rightdepth;
        }
        
    }
}
