package linkList;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
        	return false;
        }
    	ListNode p = head;  //步长小的指针
    	ListNode q = head;  //步长大的指针
    	while(q!= null && q.next != null){
    		p = p.next;
    		q = q.next.next;
    		if(p == q){
    			return true;
    		}
    	}
    	return false;
    }
    public static void main(String[] args){
    	ListNode a = new ListNode(1);
    	ListNode b = a ;
    	ListNode c = a ;
    	String t1 = new String("1");
    	String t2 = new String("1");
      	String t3 ="1";
    	System.out.println(c.equals(b));
    	System.out.println(c == b);
    	System.out.println(t1== t2);
    	System.out.println(t2== t3);
    	System.out.println(t2.hashCode()+" " + t3.hashCode());
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
      }
  }
