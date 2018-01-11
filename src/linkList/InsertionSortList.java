package linkList;

/**
 * Sort a linked list using insertion sort.
 * Created by liqiushi on 2018/1/10.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rptr = new ListNode(0);
       
        while (head != null) {
            ListNode qptr = rptr;
            ListNode pptr = head;
            head = head.next;
            while (qptr.next != null && qptr.next.val < pptr.val)
                qptr = qptr.next;
            pptr.next = qptr.next;
            qptr.next = pptr;
        }
        return rptr.next;
    }
}
