package linkList;

/**
 * Created by liqiushi on 2018/1/12.
 */
public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        if(head == null||head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
