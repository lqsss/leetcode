package structure;

import java.util.HashMap;
import java.util.Map;

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
    private int minFreq = 1;

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
        if (capacity <= 0) {
            return;
        }
        LinkNode linkNode = kvMap.get(key);

        if (linkNode != null) {
            linkNode.val = value;

        } else {

            linkNode = new LinkNode(key, value);
            linkNode.freq = 0;

            if (count + 1 > capacity) {
                DoubleLinkNodeList doubleLinkNodeList = freqMap.get(minFreq);
                LinkNode toRemove = doubleLinkNodeList.dummyTail.prev;
                doubleLinkNodeList.remove(toRemove, true);
                count--;
                kvMap.remove(toRemove.key);

            }
            count++;
        }

        kvMap.put(key, add2Head(linkNode));
    }

    private LinkNode add2Head(LinkNode linkNode) {
        Integer freq = linkNode.freq;
        Integer update = linkNode.freq + 1;


        DoubleLinkNodeList linkNodeList = freqMap.get(freq);
        //del 当前freq
        if (linkNodeList != null) {
            linkNodeList.remove(linkNode, false);

            //update freq

        } else {
            if (freq != 0) {
                linkNodeList = new DoubleLinkNodeList();
                freqMap.put(update, linkNodeList);
            }
        }

        //remove
        //add freq + 1
        linkNodeList = freqMap.get(update);
        if (linkNodeList == null) {
            linkNodeList = new DoubleLinkNodeList();
            freqMap.put(update, linkNodeList);
        }

        linkNode.freq = linkNode.freq + 1;
        linkNodeList.add(linkNode);

        updateMinFreq(Math.min(update, minFreq));
        return linkNode;
    }

    private void updateMinFreq(int freq) {

        minFreq = freq;
    }


    class LinkNode {

        LinkNode prev;

        LinkNode next;

        Integer val;

        Integer key;

        Integer freq;

        public LinkNode(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleLinkNodeList {
        int count;
        LinkNode dummyHead;
        LinkNode dummyTail;

        public DoubleLinkNodeList() {
            count = 0;
            dummyHead = new LinkNode(-1, -1);
            dummyHead.prev = null;

            dummyTail = new LinkNode(-1, -1);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            dummyTail.next = null;
        }

        public void remove(LinkNode linkNode, boolean insert) {

            LinkNode prev = linkNode.prev;
            prev.next = linkNode.next;
            linkNode.next.prev = prev;
            count--;

            //1. put/get旧 : +1
            //2. put插入新值淘汰 :
            if (count == 0 && linkNode.freq == minFreq) {
                minFreq = insert ? 1 : minFreq + 1;
            }
        }


        public void add(LinkNode linkNode) {
            LinkNode next = dummyHead.next;
            dummyHead.next = linkNode;
            linkNode.prev = dummyHead;
            linkNode.next = next;
            next.prev = linkNode;
            count++;
        }
    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(1);
        cache.put(2, 1);

        System.out.println(cache.get(2));       // 返回 1
        cache.put(3, 2);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3

    }


}
