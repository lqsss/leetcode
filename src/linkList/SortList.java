package linkList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Created by liqiushi on 2018/1/9.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用快慢指针分割
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表截断  head->prev->null、slow->fast->null/slow-null
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode rptr = result;
        ListNode pptr = l1;
        ListNode qptr = l2;
        //遍历l1、l2
        while (pptr != null && qptr != null) {
            if (pptr.val <= qptr.val) {
                rptr.next = pptr;
                pptr = pptr.next;
            } else {
                rptr.next = qptr;
                qptr = qptr.next;
            }
            rptr = rptr.next;
        }
        if (pptr != null) {
            rptr.next = pptr;
        } else {
            rptr.next = qptr;
        }
        //若其中一个队列遍历完毕
        return result.next;
    }
}

