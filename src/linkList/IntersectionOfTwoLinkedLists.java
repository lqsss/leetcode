package linkList;

import java.util.HashSet;
import java.util.Map;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    	ListNode p = headA;
    	ListNode q = headB;
    	HashSet<ListNode> tmpSet = new HashSet<ListNode>();
    	while(p!= null){
    		tmpSet.add(p);
    		p = p.next;
    	}
    	while(q != null){
    		if(tmpSet.contains(q)){
    			return q;
    		}
    		q = q.next;
    	}
    	return null;
    }
    
    
    /**
     * 两个链表长度不一，遍历两个链表，会有一个先走到终点
     * 让走到终点的重新引用另一个链表的头指针，继续遍历，直到另一个长链表的遍历指针到尾部，也重新引入另一个链表的头指针
     * 之间拉开了长度差的距离，这样再次遍历，如果存在的话，必然相遇
     * @param headA
     * @param headB
     * @return
     */
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode p = headA;
    	ListNode q = headB;

    	if(p!= null && q != null && p == q){
    		return p;
    	}
    	
    	while(p!= null && q!=null){
    		p = p.next;
    		q = q.next;
    	}
    	
    	if(p == null)
    		p = headB;
    	else{
    		q = headA;
    	}
    	
    	while(p!= null && q!=null){
    		p = p.next;
    		q = q.next;
    	}
    	
    	if(p == null)
    		p = headB;
    	else{
    		q = headA;
    	}
    	
    	while(p!= null && q!=null){
    		if(p == q)
    			return p;
    		p = p.next;
    		q = q.next;
    	}

    	return null;
    }
}
