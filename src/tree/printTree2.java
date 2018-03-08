package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liqiushi on 2018/3/5.
 */
public class printTree2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        if (pRoot == null) {
            return arr;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int rowNum = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> rowArr = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode root = queue.poll();
                rowArr.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            if (rowNum % 2 == 0) {
                Collections.reverse(rowArr);
            }
            arr.add(rowArr);
            rowNum++;
        }
        return arr;
    }

    public static void main(String[] args) {
        
    }
}
