package tree;

/**
 * Created by liqiushi on 2018/3/3.
 */
public class TreeLinkNodeGetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null ) {
            return null;
        }

        //判断是否有右子树,如果有右子树,则返回该右子树最左的孩子
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
            
        }
        //如果没有右子树
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
