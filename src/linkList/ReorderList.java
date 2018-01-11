package linkList;

/**
 * Created by liqiushi on 2018/1/11.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null
                || head.next == null
                || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        // 找到中间结点  
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);

        ListNode first = head;
        // 把第二个链表插在第一个链表中  
        ListNode fptr = null;
        ListNode sptr = null;
        while (second != null) {
            fptr = first.next;
            sptr = second.next;
            first.next = second;
            second.next = fptr;
            first = fptr;
            second = sptr;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode headPtr = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = headPtr;
            headPtr = head;
            head = next;
        }
        return headPtr;
    }
}
