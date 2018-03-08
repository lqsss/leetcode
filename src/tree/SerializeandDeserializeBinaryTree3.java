package tree;

import java.util.*;
/**
 * Created by liqiushi on 2018/3/1.
 */
public class SerializeandDeserializeBinaryTree3 {
    static int i = 0;
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            TreeNode current = stack.pop();
            if(current == null){
                sb.append("&").append(",");
            }else{
                sb.append(current.val).append(",");
                stack.push(current.right);
                stack.push(current.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public  TreeNode deserialize(String data) {
        Queue<String> qstr = new LinkedList<>();
        System.out.println(data);
        data = data.substring(0, data.length()-1);
        System.out.println(data);
        Collections.addAll(qstr,data.split(","));
        TreeNode root = travle(qstr);
        return root;
    }

    private TreeNode travle(Queue<String> qstr) {
        if(!qstr.isEmpty()){
            TreeNode root = null;
            String val = qstr.poll();
            if(val.equals("&")){
                 root = null;
            }else{
                 root = new TreeNode(Integer.parseInt(val));
                root.left = travle(qstr);
                root.right = travle(qstr);
            }
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        TreeNode t = new SerializeandDeserializeBinaryTree3().deserialize(serialize(root));
        new SerializeandDeserializeBinaryTree3().i = 2;
        System.out.println(new SerializeandDeserializeBinaryTree3().i);
        
    }
}
