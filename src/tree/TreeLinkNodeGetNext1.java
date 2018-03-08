/*
package tree;

import java.util.ArrayList;

*/
/**
 * Created by liqiushi on 2018/3/2.
 *//*

public class TreeLinkNodeGetNext1 {
    private ArrayList<Integer> arrayList = null;
    private Boolean isLeft = true;

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.left != null && pNode.right != null) {
            //说明是小型二叉子树的根节点
            return pNode.right;
        }
        if (pNode.left != null && pNode.right == null) {
            //说明是小型二叉子树的根节点
            return pNode.next;
        }
        //叶子节点
        TreeLinkNode cur = pNode.next;
        TreeLinkNode root = pNode;
        while (cur != null) {
            if (cur.left == root) {
                isLeft = true;
            }
            if (cur.right == root) {
                isLeft = false;
            }
            root = cur;
            cur = cur.next;
        }
        if (pNode == root) {
            //说明没有移动
            return null;
        }
        if (pNode.next.left == pNode) {
            return pNode.next;
        } else {
            if (isLeft) {
                return root;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(3);
        TreeLinkNode t1 = new TreeLinkNode(5);
        TreeLinkNode t2 = new TreeLinkNode(11);
        TreeLinkNode t3 = new TreeLinkNode(7);
        TreeLinkNode t4 = new TreeLinkNode(9);
        TreeLinkNode t5 = new TreeLinkNode(13);
        TreeLinkNode t6 = new TreeLinkNode(15);
        root.left = t1;
        root.right = t2;
        t1.next = root;
        t2.next = root;
        t1.left = t3;
        t1.right = t4;
        t3.next = t1;
        t4.next = t1;
        t2.left = t5;
        t2.right = t6;
        t5.next = t2;
        t6.next = t2;
        TreeLinkNode result = new TreeLinkNodeGetNext().GetNext(t6);
        System.out.println(result.val);
    }
}
*/
