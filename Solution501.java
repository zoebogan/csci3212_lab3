//Traverses through the tree checking each node
public class Solution501 {
    class Solution {
        public int[] findMode(TreeNode root) {
            int maxCount = 0;
            int currCount = 0;
            int currNum = 0;
            List<Integer> value = new ArrayList();

            TreeNode node = root;
            while (node != null) {
                if (node.left != null) {
                    TreeNode neighbor = node.left;
                    while (neighbor.right != null) {
                        neighbor = neighbor.right;
                    }
                    neighbor.right = node;
                    TreeNode left = node.left;
                    node.left = null;
                    node = left;
                } else {
                    int num = node.val;
                    if (num == currNum) {
                        currCount++;
                    } else {
                        currCount = 1;
                        currNum = num;
                    }
                    if (currCount > maxCount) {
                        value = new ArrayList();
                        maxCount = currCount;
                    }
                    if (currCount == maxCount) {
                        value.add(num);
                    }
                    node = node.right;
                }
            }
            int[] result = new int[value.size()];
            for (int i = 0; i < value.size(); i++) {
                result[i] = value.get(i);
            }
            return result;
        }
    }
}