package TreeBasic;

public class Node<T extends Comparable>{
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T data){
        this.value = data;
    }
    public Node(Node<T> left, Node<T> right, T value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(){

    }

    public Node<T> getLeft(){
        return this.left;
    }
    public void setLeft(Node<T> left){
        this.left = left;
    }
    public Node<T> getRight(){
        return this.right;
    }
    public void setRight(Node<T> right){
        this.right = right;
    }
    public T getValue(){
        return this.value;
    }
    public void setValue(T value){
        this.value = value;
    }
}  

