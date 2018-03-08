package tree;

/**
 * Created by liqiushi on 2018/3/6.
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                res = DoseTree1HasTree2(root1, root2);
            }

            if (!res) {
                res = HasSubtree(root1.left, root2);
            }

            if (!res) {
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    private boolean DoseTree1HasTree2(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        
        if(root1 == null){
            return false;
        }
        
        if(root1.val != root2.val){
            return false;
        }
        
        return DoseTree1HasTree2(root1.left,root2.left) && DoseTree1HasTree2(root1.right,root2.right);
    }
}
