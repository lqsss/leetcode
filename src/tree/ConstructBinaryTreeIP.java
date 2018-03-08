package tree;

import java.util.Arrays;

/**
 * Created by liqiushi on 2018/2/27.
 */
public class ConstructBinaryTreeIP {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        if (postorder.length == 0 || inorder.length == 0) {
            return root;
        }
        root = new TreeNode(postorder[postorder.length-1]);
        int tmp = 0;
        for (int i = 0; i < inorder.length; i++) {
            tmp = i;
            if(root.val == inorder[i]){
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder,0,tmp);
        int[] rightInorder = Arrays.copyOfRange(inorder,tmp+1,inorder.length);
        int[] leftPostorder = Arrays.copyOfRange(postorder,0,tmp);
        int[] rightPostorder = Arrays.copyOfRange(postorder,tmp,postorder.length-1);
        root.left = buildTree(leftInorder,leftPostorder);
        root.right = buildTree(rightInorder,rightPostorder);
        return root;
    }
}
