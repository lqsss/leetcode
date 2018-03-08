package tree;

import java.util.Arrays;

/**
 * Created by liqiushi on 2018/2/26.
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder.length == 0 || inorder.length == 0) {
            return root;
        }
        root = new TreeNode(preorder[0]);
        int tmp = 0;
        for (int i = 0; i < inorder.length; i++) {
            tmp = i;
            if(preorder[0] == inorder[i]){
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder,0,tmp);
        int[] rightInorder = Arrays.copyOfRange(inorder,tmp+1,inorder.length);
        int[] leftPreorder = Arrays.copyOfRange(preorder,1,1+tmp);
        int[] rightPreorder = Arrays.copyOfRange(preorder,tmp+1,preorder.length);
        root.left = buildTree(leftPreorder,leftInorder);
        root.right = buildTree(rightPreorder,rightInorder);
        return root;
    }
    
}
