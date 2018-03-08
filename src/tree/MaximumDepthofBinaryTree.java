package tree;

/**
 * Created by liqiushi on 2018/2/22.
 */
public class MaximumDepthofBinaryTree {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = TreeDepth(root.left);
        int rightHight = TreeDepth(root.right);
        return leftHight >= rightHight ? leftHight + 1 : rightHight + 1;
    }
}
