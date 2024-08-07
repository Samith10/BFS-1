// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int lvl = 1;

        while (!q.isEmpty() && lvl > 0) {
            TreeNode node = q.poll();
            if (node != null) {
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                list.add(node.val);
            }
            lvl--;

            if (lvl == 0) {
                result.add(list);
                lvl = q.size();
                list = new ArrayList<>();
            }
        }
        return result;
    }
}