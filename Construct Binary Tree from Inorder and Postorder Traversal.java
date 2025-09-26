Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 
Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder, 0 , inorder.length-1, postorder, 0 , postorder.length-1);
    }
    private TreeNode solve(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if(istart > iend || pstart > pend) {
            return null;
        }
        int val = postorder[pend];
        TreeNode root = new TreeNode(val);
        
        int rootindex = 0;
        for(int i=istart;i<=iend;i++) {
            if(inorder[i] == val) {
                rootindex = i;
                break;
            }
        }
        int leftsize = rootindex - istart;
        int rightsize = iend - rootindex;

        root.left = solve(inorder, istart, rootindex-1, postorder, pstart, pstart+leftsize-1);
        root.right = solve(inorder, rootindex+1, iend, postorder, pend-rightsize, pend-1);

        return root;
    }
}
