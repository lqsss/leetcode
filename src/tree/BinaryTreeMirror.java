package tree;

/**
 * Created by liqiushi on 2018/2/24.
 */
public class BinaryTreeMirror {
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        if (root.left != null) {w
            Mirror(root.left);
        } 
        if (root.right != null) {
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);

        root.left = t1;
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        BinaryTreeMirror.Mirror(root);
    }
}
