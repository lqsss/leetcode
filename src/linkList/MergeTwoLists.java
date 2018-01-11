package linkList;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.+
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * Created by liqiushi on 2018/1/8.
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        if(pptr!=null){
            rptr.next = pptr;
        }else{
            rptr.next = qptr;
        }
/*        while (pptr == null && qptr != null) {
            ListNode tmpNode = new ListNode(qptr.val);
            rptr.next = tmpNode;
            rptr = rptr.next;
            qptr = qptr.next;
        }
        while (qptr == null && pptr != null) {
            ListNode tmpNode = new ListNode(pptr.val);
            rptr.next = tmpNode;
            rptr = rptr.next;
            pptr = pptr.next;
        }*/
        //若其中一个队列遍历完毕
        return result.next;
    }
}
