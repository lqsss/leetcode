package tree;

public class SerializeandDeserializeBST2 {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        String data = "";
        if (root == null) {
            return "&,";
        }
        data += root.val + "," + serialize(root.left) + serialize(root.right);
        return data;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "") {
            return null;
        }
        data = data.substring(0, data.length());
        String[] tmp = data.split(",");
        TreeNode root = dfs(tmp);
        return root;
    }

    private int i = 0;

    public TreeNode dfs(String[] tmp) {
        if (i < 0 || i >= tmp.length) {
            return null;
        }
        String valStr = tmp[i];
        i++;
        if(valStr.equals("&")){
            return null;
        }else{
            int val= Integer.parseInt(valStr);
            TreeNode root = new TreeNode(val);
            root.left = dfs(tmp);
            root.right = dfs(tmp);
            return root;
        }
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
        System.out.println(serialize(root));
    }
}
