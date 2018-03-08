package tree;

/**
 * Created by liqiushi on 2018/2/5.
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        sum = sum(root, sum);
        return sum;
    }

    private int sum(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        if(root.left != null ){
            if (root.left.left == null&&root.left.right == null) {
                sum += root.left.val ;
            }else if(root.left.left != null||root.left.right !=null){
                sum = sum(root.left, sum);
            }
        }
 
        if (root.right != null) {
            sum = sum(root.right, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-9);
        TreeNode t1 = new TreeNode(-3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(-6);
        TreeNode t7 = new TreeNode(-5);
        root.left = t1;
        root.right = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t4.left = t7;
        int result = 0;
        result = new SumofLeftLeaves().sumOfLeftLeaves(root);
        System.out.println(result);
    }

}
