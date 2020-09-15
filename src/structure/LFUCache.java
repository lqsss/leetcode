package structure;

import java.util.HashMap;

public class LFUCache {

    /**
     * 容量
     */
    private int capacity;

    /**
     * 当前元素的数量
     */
    private int count;

    /**
     * 最小频次
     */
    private int minFreq;

    /**
     * key-LinkNode 数据map
     */
    private HashMap<Integer, LinkNode> kvMap;

    /**
     * frequency-DoubleLinkNodeList 频率map
     */
    private HashMap<Integer, DoubleLinkNodeList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        kvMap = new HashMap<>();
        freqMap = new HashMap<>();

    }

    public int get(int key) {
        LinkNode linkNode = kvMap.get(key);
        if (linkNode == null) {
            return -1;
        }

        //更新频次freq + 1 ，移动到 freq + 1下指向链表的头部
        add2Head(linkNode);
        return linkNode.val;
    }

    public void put(int key, int value) {

    }

    private void add2Head(LinkNode linkNode) {
        Integer freq = linkNode.freq;
        DoubleLinkNodeList linkNodeList = freqMap.get(freq);
        //del 当前freq
        linkNodeList.remove(linkNode);

        linkNode.freq = linkNode.freq + 1;
        //update freq
        if (freq == minFreq && linkNodeList.count == 0) {
            updateMinFreq(linkNode.freq);
        }

        //add freq + 1
        linkNodeList = freqMap.get(linkNode.freq);
        linkNodeList.add(linkNode);
    }

    private void updateMinFreq(int freq) {

        minFreq = freq;
    }


    class LinkNode {

        LinkNode prev;

        LinkNode next;

        Integer val;

        Integer freq;
    }

    class DoubleLinkNodeList {
        int count;
        LinkNode dummyHead;
        LinkNode dummyTail;

        public DoubleLinkNodeList() {
            count = 0;
            dummyHead = new LinkNode();
            dummyHead.prev = null;
            dummyHead.next = dummyTail;
            dummyTail = new LinkNode();
            dummyTail.prev = dummyHead;
            dummyTail.next = null;
        }

        public void remove(LinkNode linkNode) {
            LinkNode prev = linkNode.prev;
            prev.next = linkNode.next.next;
            linkNode.next.next.prev = prev;
            count--;
        }

        public void add(LinkNode linkNode) {
            LinkNode next = dummyHead.next;
            dummyHead.next = linkNode;
            linkNode.prev = dummyHead;
            next.prev = linkNode;
            count++;
        }
    }

    public static void main(String[] args) {

    }


}
