package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 2018/2/1.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        searchBst(root, "", resultList);
        return resultList;
    }

    private void searchBst(TreeNode root, String path, List<String> resultList) {
        if (root.left == null && root.right == null) {
            resultList.add(path + root.val );
        }
        if (root.left != null) {
            searchBst(root.left, path + root.val + "->", resultList);
        }
        if (root.right != null) {
            searchBst(root.right, path + root.val + "->", resultList);
        }
    }
}
