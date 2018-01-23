package TreeBasic;


import java.util.Scanner;

/**
 * Created by liqiushi on 2018/1/14.
 */

public class BinaryTree<T extends Comparable> {
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public static int count = 1;

/**
 * 先序创建二叉树
 *
 * @param root
 * @return
 */

    public Node<T> createTree(Node<T> root, char[] data, int i) {
        if (i > data.length || data[i] == '#') {
            return null;
        }
        root = new Node(data[i]);
        root.setLeft(createTree(root.getLeft(), data, ++count));
        root.setRight(createTree(root.getRight(), data, ++count));
        return root;
    }
/*    public void createTree(Node node,char[] data, int i){
        if (i > data.length || data[i] == '#') {
            return;
        }
        if(root == null){
            root = new Node(data[i]);
        }else{
            createTree(node.getLeft(),data,++count);
            createTree(node.getRight(),data,++count);
        }
    }*/

    public void preOrder(Node<T> root) {
        if (root != null) {
            System.out.println(root.getValue());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void main(String[] args) {
        BinaryTree<Character> binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        //值传递，传递的只是个root的副本，不会改变原来root的指向
        binaryTree.setRoot(binaryTree.createTree(binaryTree.getRoot(), s.toCharArray(), binaryTree.count));
        binaryTree.preOrder(binaryTree.getRoot());
/*        binaryTree.setRoot(new Node<Character>(s.toCharArray()[0]));
        binaryTree.createTree(binaryTree.getRoot(), s.toCharArray(), binaryTree.count);*/
        binaryTree.preOrder(binaryTree.getRoot());
    }
}

/*
-+a##*##/e##f##*/

/*
public class BinaryTree<T> {

    */
/*二叉树的根节点*//*

    private Node<T> root;

    public BinaryTree() {
    }

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

*/
/**先序遍历创建二叉树*//*

    */
/**
     * input.txt: - + a # # * # # / e # # f # #
     * # 代表空结点
     *//*

    public void createBiTree() {
        Scanner scn = null;

        try {
            scn = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.root = createBiTree(root, scn);
    }

    private Node<T> createBiTree(Node<T> node, Scanner scn) {

        String temp = scn.next();
        if (temp.trim().equals("#")) {
            return null;
        } else {
            node = new Node<T>((T) temp);
            node.setLeft(createBiTree(node.getLeft(), scn));
            node.setRight(createBiTree(node.getRight(), scn));
            return node;
        }
    }

    */
/**
     * 先序递归遍历二叉树
     *//*

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    private void preOrderTraverse(Node<T> node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrderTraverse(node.getLeft());
            preOrderTraverse(node.getRight());
        }
    }


    */
/**
     * 先序非递归遍历二叉树
     *//*

    public void nrPreOrderTraverse() {
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.getValue());
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            node = node.getRight();
        }
    }


    */
/**
     * 中序递归遍历二叉树
     *//*

    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node<T> node) {
        if (node != null) {
            inOrderTraverse(node.getLeft());
            System.out.println(node.getValue());
            inOrderTraverse(node.getRight());
        }
    }

    */
/**
     * 中序非递归遍历二叉树
     *//*

    public void nrInOrderTraverse() {
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            System.out.println(node.getValue());
            node = node.getRight();
        }
    }

INSERT INTO table values(1,2) ;
INSERT INTO table (xxx,xxx) values(1,2) ;

UPDATE table set xxx = xxx ,xxx= xxx where = xxx
    
    


    public static void main(String[] args) {
        BinaryTree<String> bt = new BinaryTree<String>();
        bt.createBiTree();
        //bt.preOrderTraverse();  
        //bt.inOrderTraverse();  
        //bt.postOrderTraverse();  
        //bt.nrPreOrderTraverse();  
        //bt.nrInOrderTraverse();  
        //bt.nrPostOrderTraverse();  
       
    }
}  */
