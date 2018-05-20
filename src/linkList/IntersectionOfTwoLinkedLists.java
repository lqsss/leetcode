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
     * ���������Ȳ�һ������������������һ�����ߵ��յ�
     * ���ߵ��յ������������һ�������ͷָ�룬����������ֱ����һ��������ı���ָ�뵽β����Ҳ����������һ�������ͷָ��
     * ֮�������˳��Ȳ�ľ��룬�����ٴα�����������ڵĻ�����Ȼ����
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
