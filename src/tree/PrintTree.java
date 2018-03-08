package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liqiushi on 2018/3/2.
 */
public class PrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode currNode = queue.poll();
                list.add(currNode.val);
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
