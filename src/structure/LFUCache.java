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
        return -1;
    }

    public void put(int key, int value) {

    }


    class LinkNode {

        LinkNode prev;

        LinkNode next;
    }

    class DoubleLinkNodeList {
        LinkNode dummyHead;
        LinkNode dummyTail;

        public DoubleLinkNodeList() {
            dummyHead = new LinkNode();
            dummyHead.prev = null;
            dummyHead.next = dummyTail;
            dummyTail = new LinkNode();
            dummyTail.prev = dummyHead;
            dummyTail.next = null;
        }
    }

    public static void main(String[] args) {

    }


}
