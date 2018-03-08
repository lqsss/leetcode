package tree;

/**
 * Created by liqiushi on 2018/1/31.
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return root;
        }
        if(root.val < L ){
            return trimBST( root.right,  L,  R);
        }else if(root.val > R){
            return trimBST( root.left,  L,  R);
        }
        root.left = trimBST( root.left,  L,  R);
        root.right = trimBST( root.right,  L,  R);
        return root;
    }
}
