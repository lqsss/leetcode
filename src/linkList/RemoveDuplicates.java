package linkList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = head;
        if (currentNode.val == currentNode.next.val) { //如果当前节点是重复的节点
            currentNode = currentNode.next;
            while (currentNode != null && currentNode.val == head.val) {
                currentNode = currentNode.next; //找到第一个不相同值的节点
            }
            return deleteDuplicates(currentNode);
        }else{  //不重复
            currentNode.next = deleteDuplicates(currentNode.next);
            return head;
        }
    }
}
