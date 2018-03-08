package tree;

/**
 * Created by liqiushi on 2018/2/23.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root!=null){
            int leftHight = TreeDepth(root.left);
            int rightHight = TreeDepth(root.right);
            if(leftHight -rightHight < - 1 || leftHight -rightHight >1){
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = TreeDepth(root.left);
        int rightHight = TreeDepth(root.right);
        return leftHight >= rightHight ? leftHight + 1 : rightHight + 1;
    }
}
