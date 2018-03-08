package tree;


/**
 * Created by liqiushi on 2018/1/26.
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        Boolean isLeft = false;
        TreeNode currentNode = root;
        TreeNode parentNode = root;
        if (root == null) {
            return root;
        }
        while (currentNode != null && currentNode.val != key) {
            parentNode = currentNode;
            if (key < currentNode.val) {
                currentNode = currentNode.left;
                isLeft = true;
            } else if (key > currentNode.val) {
                currentNode = currentNode.right;
                isLeft = false;
            }
        }
        if (currentNode == null) {
            return root;
        }
        //1.叶子节点
        if (currentNode.left == null && currentNode.right == null) {
            if(currentNode == root){
                root = null;
            }/*else if(isLeft){
                parentNode.left = null;
            }else{
                parentNode.right = null;
            }*/
            else{
                currentNode = null;
            }
            return root;
        }
        //2.只有左或右
        if (currentNode.left == null ) {
            if(currentNode == root){
                root = currentNode.right;
            } else if(isLeft){
                parentNode.left = currentNode.right;
            }else{
                parentNode.right = currentNode.right;
            }
        }else if(currentNode.right == null){
            if(currentNode == root){
                root = currentNode.left;
            }else if(isLeft){
                parentNode.left = currentNode.left;
            }else{
                parentNode.right = currentNode.left;
            }
        }
        //3. 左右都有
        if(currentNode.right != null && currentNode.left != null ){
            TreeNode tmpNode = currentNode.right;
            TreeNode parentTmpNode = tmpNode;
            while(tmpNode.left!= null){
                parentTmpNode = tmpNode;
                tmpNode = tmpNode.left;
            }
            if(tmpNode == currentNode.right){
                currentNode.right = tmpNode.right;
            }else{
                parentTmpNode.left = tmpNode.right; 
            }
            currentNode.val = tmpNode.val;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}