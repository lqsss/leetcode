package linkList;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
    	if(head == null){
    		return null;
    	}
    	ListNode p = head;
    	while(p.next != null){
    		if( p.next.val == val){
    			p.next = p.next.next;
    		}
    		else{
        		p = p.next;
    		}
    	}
    	if(head.val == val){
    		head = head.next;
    	}
		return head;
    }
}
