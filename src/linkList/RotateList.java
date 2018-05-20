package linkList;

/**
 * Created by liqiushi on 2017/12/14.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        //1、获取长度
        //2、找到倒数第K个位置
        ListNode p = head;
        ListNode last = head;
        int length = 0;
        while (p != null) {
            length++;
            if (p.next == null) {
                last = p;
            }
            p = p.next;
        }
        k = k % length;
        if (k == 0)
            return head;
        p = head;
        ListNode right = head;
        for (int i = 0; i < length - k - 1; i++) {
            p = p.next;
        }
        right = p;
        p = p.next;
        //得到第K个位置
        right.next = null;
        last.next = head;
        if (p == null) {
            return head;
        }
        return p;
    }
}
