package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Created by liqiushi on 2018/1/30.
 */
public class AverageOfLevelsInBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageList = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            double avarage = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode currentNode = queue.peek();
                sum += currentNode.val;
                queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            avarage = (double)sum / n; 
            averageList.add(avarage);
        }
        return averageList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(15);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        averageOfLevels(root);
    }
}
