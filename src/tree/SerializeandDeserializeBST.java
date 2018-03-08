package tree;


import java.util.ArrayList;
import java.util.Arrays;

public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //前序遍历
        ArrayList preorder = new ArrayList();
        preOrder(root, preorder);
        String preStr = preorder.toString();
        //中序
        ArrayList inorder = new ArrayList();
        inOrder(root, inorder);
        String inStr = inorder.toString();
        String serializeStr = preStr + '&' + inStr;
        return serializeStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "" || data == null)
            return null;
        
        String preStr = data.split("&")[0];
        int[] preorder = getIntArr(preStr);
        
        String inStr =  data.split("&")[1];
        int[] inorder = getIntArr(inStr);
        TreeNode root = buildTree(preorder,inorder);
        return root;
    }

    public void preOrder(TreeNode root, ArrayList preorder) {
        if (root != null) {
            preorder.add(root.val);
            preOrder(root.left, preorder);
            preOrder(root.right, preorder);
        }
    }

    public void inOrder(TreeNode root, ArrayList inorder) {
        if (root != null) {
            preOrder(root.left, inorder);
            inorder.add(root.val);
            preOrder(root.right, inorder);
        }
    }

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
    
    public static int[] getIntArr(String data){
        data =data.substring(1,data.length()-1);
        String[] dataArr = data.split(",");
        int[] result = new int[dataArr.length];
        for (int i = 0; i < dataArr.length; i++) {
            result[i] = Integer.parseInt(dataArr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        String data = "[1,2,3,4]&[5,6,7,8]";
        String preStr = data.split("&")[0];
        int[] result = getIntArr(preStr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
/*        preStr =preStr.substring(1,preStr.length()-1);
        String[] preArr = preStr.split(",");
        ArrayList<Integer> result = new ArrayList();
        for (String item:preArr) {
            result.add(Integer.valueOf(item));
        }

        String inStr =  data.split("&")[1];
        System.out.println(result.toString());*/
    }
}
