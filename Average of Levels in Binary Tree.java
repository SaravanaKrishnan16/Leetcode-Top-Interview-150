Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 
Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 
Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Double> res = new ArrayList<>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()){
            double sum = 0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            double avg = sum/size;
            res.add(avg);
        }
        return res;
    }
}
