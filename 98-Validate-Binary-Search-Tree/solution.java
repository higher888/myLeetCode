/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class ResultType{
        boolean is_bst;
        int maxValue, minValue;
        ResultType(boolean is_bst, int maxValue, int minValue){
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        ResultType result = isValidHelper(root);
        return result.is_bst;
    }
    
    private ResultType isValidHelper(TreeNode root){
        if (root == null){
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE); //important code here
        }
        //divide
        ResultType leftTree = isValidHelper(root.left);
        ResultType rightTree = isValidHelper(root.right);
        //conquer
        if (!leftTree.is_bst || !rightTree.is_bst){
            return new ResultType(false, 0, 0);
        }
        if (root.left != null && leftTree.maxValue >= root.val || root.right != null && rightTree.minValue <= root.val){
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.max(rightTree.maxValue, root.val), Math.min(leftTree.minValue, root.val));
    }
}