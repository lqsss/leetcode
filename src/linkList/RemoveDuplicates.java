package linkList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode currentNode = head;
        while(currentNode != null && currentNode.next != null){
        	if(currentNode.val == currentNode.next.val){
        		currentNode.next = currentNode.next.next;
        	}else{
        		currentNode = currentNode.next;
        	}
        }
        return head;
    }
}
