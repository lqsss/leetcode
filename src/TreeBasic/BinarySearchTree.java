package TreeBasic;

/**
 * Created by liqiushi on 2018/1/17.
 */
public class BinarySearchTree<T extends Comparable> {
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }


    /**
     * 查找最大值的节点
     *
     * @param root
     * @return
     */
    public Node maximum(Node<T> root) {
        if (root == null) {
            return null;
        }
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    /**
     * 查找最小值的节点
     *
     * @param root
     * @return
     */
    public Node minimum(Node<T> root) {
        if (root == null) {
            return null;
        }
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }


    /**
     * 查找
     * @param root
     * @param data
     * @return
     */
    public Node<T> searchBST(Node root, T data) {
        if (root == null) {
            return root;
        } else {
            if (root.getValue().compareTo(data) == 0) {
                return root;
            } else if (root.getValue().compareTo(data) < 0) {
                return searchBST(root.getLeft(), data);
            } else {
                return searchBST(root.getRight(), data);
            }
        }
    }

    /**
     * 插入二叉树
     *
     * @param root
     * @param data
     */
    public Node insertBST(Node root, T data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        int cResult = data.compareTo(root.getValue());
        //插入左子树
        if (cResult < 0) {
            root.setLeft(insertBST(root.getLeft(), data));
        }
        //插入右子树
        if (cResult > 0) {
            root.setRight(insertBST(root.getRight(), data));
        }
        return root;
    }

    /**
     * 删除二叉查找树上的某一个节点
     * 1. 若是叶子节点，对此节点删除不影响整体树的结构，只需修改双亲节点即可
     * 2. 若是只有左子树或只有右子树的节点
     * 3. 若是左子树和右子树都在的节点
     */
    public boolean deleteBST(T data) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeft = false;
        //查找
        while (currentNode != null && currentNode.getValue() != data) {
            parentNode = currentNode;
            int cResult = data.compareTo(currentNode.getValue());
            if (cResult > 0) {
                currentNode = currentNode.getRight();
                isLeft = false;
            } else if (cResult < 0) {
                currentNode = currentNode.getLeft();
                isLeft = true;
            }
        }
        if (currentNode == null) {
            System.out.println("delete err: not found this node");
            return false;
        }
        //假设是叶子节点
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == root) {
                root = null;
            } else if(isLeft){
                parentNode.setLeft(null);
            }else{
                parentNode.setRight(null);
            }
            return true;
        }
        if (currentNode.getRight() == null) {
            if (currentNode == root) {
                root = currentNode.getLeft();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        } else if (currentNode.getLeft() == null) {
            if (currentNode == root) {
                root = currentNode.getRight();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        } else if (currentNode.getLeft() != null && currentNode.getRight() != null) {
            //都不为空的情况,找到前驱或后继(该节点左子树的最大数、右子树的最小树)
            //1.先找到前驱或后继节点 赋值 删除
            //2.移动位置
            Node tmpNode = currentNode.getRight();//后继
            Node tmpParentNode = tmpNode;
            while (tmpNode.getLeft() != null) {
                tmpParentNode = tmpNode;
                tmpNode = tmpNode.getLeft();
            }
            if(tmpNode != currentNode.getRight()){
                tmpParentNode.setLeft(tmpNode.getRight());
            }else{
                currentNode.setRight(tmpNode.getRight());
            }
            currentNode.setValue(tmpParentNode.getValue());
        }
        return true;
    }

    public void midOrderTravel(Node root) {
        if (root == null) {
            return;
        }
        midOrderTravel(root.getLeft());
        System.out.println(root.getValue());
        midOrderTravel(root.getRight());
    }

    public static void main(String[] args) {
        int[] src = new int[]{2, 54, 88, 43, 1, 22,30};
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.setRoot(new Node(5));
        Node root = bst.getRoot();
        for (int item : src) {
            root = bst.insertBST(root, item);
        }
        if(bst.deleteBST(30)){
           bst.midOrderTravel(bst.getRoot());
        }

        //bst.midOrderTravel(root);
/*        Node result = bst.searchBST(root, 8);
        System.out.println(result.getValue());*/
    }
}
