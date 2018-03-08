package tree;

import java.util.ArrayList;

/**
 * Created by liqiushi on 2018/3/4.
 */
public class KthNode {
    private ArrayList<TreeNode> arr = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null){
            return null;
        }
        if(k <= 0){
            return null;
        }
        midOrder(pRoot);
        if(k > arr.size()  ){
            return null;
        }
        TreeNode result = arr.get(k-1);
        
        return result;
    }

    private void midOrder(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        midOrder(pRoot.left);
        arr.add(pRoot);
        midOrder(pRoot.right);
    }



/*       int index = 0; //计数器
        TreeNode KthNode(TreeNode root, int k)
        {
                if(root != null){ //中序遍历寻找第k个
                        TreeNode node = KthNode(root.left,k);
                        if(node != null)
                            return node;
                        index ++;
                        if(index == k)
                            return root;
                        node = KthNode(root.right,k);
                        if(node != null)
                            return node;
                    }
                return null;
            }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(9);
        TreeNode t6 = new TreeNode(11);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        KthNode test = new KthNode();
        TreeNode res = test.KthNode(root,1);
        //System.out.println(res.val);
    }
}
