package structure.skiplist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * feat.
 * 1. 满足基础的skipList
 * 2. skipList进行扩展，支持以下操作;
 * 2.1 zscore:           查找key对应的数据
 * 2.2 zrevrank:         查看key的排名
 * 2.3 zrange:        查看多少名内的数据
 * 2.4 zrevrangebyscore: 查看分数范围内的数据，从小到大排序
 *
 * @author lqs
 * @version 1.0
 * @date 2020/7/26 12:20 下午
 */
public class SkipList {

    /**
     * 默认的最大层级
     */
    private static final int DEFAULT_MAX_LEVEL = 32;

    /**
     * 默认跨越层级为p
     */
    private static final double DEFAULT_PROBABILITY = 0.25;

    private SkipListNode head;

    private SkipListNode tail;

    /**
     * 长度
     */
    private int length;

    /**
     * 最大层级
     */
    private int maxLevel;

    /**
     * 层级
     */
    private int level;

    /**
     * 当前层级为第n层，当前节点分配到 (n+1)层的概率
     */
    private double probability;

    public SkipList(double probability, int maxLevel) {
        this.probability = probability;
        this.maxLevel = maxLevel;
        this.length = 0;
        this.level = 1;
        this.head = new SkipListNode(maxLevel);
    }

    public SkipList() {
        this(DEFAULT_PROBABILITY, DEFAULT_MAX_LEVEL);
    }

    public SkipListNode getHead() {
        return head;
    }

    public void setHead(SkipListNode head) {
        this.head = head;
    }

    public SkipListNode getTail() {
        return tail;
    }

    public void setTail(SkipListNode tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    private SkipListNode find(int score) {
        return null;
    }

    /**
     * 插入数据：
     * 1、先在skipList插入新对象数据
     * 2、再字典表dict里同步一份该新对象数据,指向1操作中的对象
     * dict和skipList是共享数据，其中不会产生重复的数据造成内存浪费
     * 允许score重复，且按照字典序排序
     *
     * @param dictName
     * @param score
     */
    public void zadd(String dictName, int score) {
        //1. 通过随机概率算法找到合适的层级
        //2. 需要更新的字段:
        //   2.1 是否更新head/tail
        //   2.2 更新pointer数组，prev指向前驱节点，next指向后面的节点
        //   2.2 前驱节点指向后续节点

        int level = getLevelRandomly();
        SkipListNode newNode = new SkipListNode(score, maxLevel, dictName);

        insert(head, level, newNode);
    }

    public void insert(SkipListNode curNode, int level, SkipListNode newNode) {

        if (level < 0) {
            return;
        }

        SkipListNode.Pointer[] pointers = curNode.getPointers();

        if (pointers[level] == null) {

            pointers[level] = new SkipListNode.Pointer(newNode);
            if (level == 0) {
                newNode.setPrev(curNode);
            }
            insert(curNode, level - 1, newNode);
        } else {

            SkipListNode next = pointers[level].getNext();
            if (next.getScore() < newNode.getScore()) {
                insert(next, level, newNode);
            } else {
                pointers[level].setNext(newNode);
                newNode.getPointers()[level] = new SkipListNode.Pointer(next);
                if (level == 0) {
                    newNode.setPrev(curNode);
                }
                insert(curNode, level - 1, newNode);
            }
        }
    }

    public SkipListNode insert(int score, String dictName) {
        int level = getLevelRandomly();

        //update数组：用来记录查找插入节点的路径
        SkipListNode[] update = new SkipListNode[Math.max(level, this.level)];
        SkipListNode newNode = new SkipListNode(score, maxLevel, dictName);

        //rank数组：用来记录与update数组对应的span
        int[] rank = new int[update.length];

        if (level > this.level) {
            for (int i = this.level; i < level; i++) {
                update[i] = head;
                rank[i] = 0;
                head.getPointers()[i].setSpan(length);
            }

            //更新最大跳表的level
            this.level = level;
        }

        //找到每层最近的左节点，方便后续插入
        for (int i = 0; i < level; i++) {

            SkipListNode cur = head;
            SkipListNode next = cur.getPointers()[i].getNext();
            while (next != null && (next.getScore() < score || next.getScore() == score && next.getDictName().compareTo(dictName) > 0)) {
                //这里累加左节点
                rank[i] += cur.getPointers()[i].getSpan();
                cur = next;
                next = cur.getPointers()[i].getNext();
            }

            update[i] = cur;
        }

        for (int i = 0; i < level; i++) {
            SkipListNode.Pointer pointer = update[i].getPointers()[i];
            pointer.setNext(newNode);
            int span = pointer.getSpan();

            newNode.getPointers()[i].setSpan(span - (rank[0] - rank[i]));
            //+1是包含新的节点
            pointer.setSpan(rank[0] - rank[i] + 1);
        }

        if (update[0] == null) {
            newNode.setPrev(head);
        } else {
            newNode.setPrev(update[0]);
        }

        SkipListNode next = newNode.getPointers()[0].getNext();
        if (next != null) {
            next.setPrev(newNode);
        } else {
            tail = newNode;
        }

        length++;
        return newNode;
    }

    public int getLevelRandomly() {
        int level = 1;
        //Math.random() < probability 跨越一层的概率为p
        while (Math.random() < probability && level < maxLevel) {
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        skipList.insert(20, "test0");
        skipList.insert(21, "test1");
        skipList.insert(21, "test2");
        skipList.insert(25, "test3");
        skipList.insert(30, "test4");
        int rank = skipList.zrank("test5");
        System.out.println(rank);
        List<String> zrange = skipList.zrange(1, 2);
    }

    /**
     * 根据字典名查找对应的数据
     * 该操作会直接在*dict里进行O(1)的查找
     *
     * @param dictName
     * @return
     */
    public int zscore(String dictName) {
        return 0;
    }


    /**
     * 根据字典名查找对应的数据排名，从头向尾
     *
     * @param dictName
     * @return
     */
    public int zrank(String dictName) {
        //1. 根据zset的dictName从dict中获取score
        //2. 从header的level - 1 开始往后遍历，累加游走节点的span
        Dict dictObj = (Dict) getObjectFromDict(dictName);
        double score = dictObj.score;
        int span = 0;

        SkipListNode curNode = head;
        SkipListNode next;

        for (int i = level - 1; i >= 0; i--) {
            SkipListNode.Pointer curNodePointer = curNode.getPointers()[i];
            next = curNodePointer.getNext();

            while (next != null && (next.getScore() < score || next.getScore() == score && dictName.compareTo(next.getDictName()) <= 0)) {

                span += curNodePointer.getSpan();
                curNode = next;
                next = curNode.getPointers()[i].getNext();
            }

            //已经找到了本身该节点
            if (dictObj.equals(new Dict(curNode.getDictName(), curNode.getScore()))) {
                return span;
            }
        }

        return 0;
    }

    /**
     * 模拟从dict里获取分数
     *
     * @param dictName
     * @return
     */
    private double getScoreFromDict(String dictName) {
        return 20;
    }

    private Object getObjectFromDict(String dictName) {
        return new Dict(dictName, 25);
    }


    class Dict {
        String dictName;
        double score;

        public Dict(String dictName, double score) {
            this.dictName = dictName;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dict dict = (Dict) o;
            return Double.compare(dict.score, score) == 0 &&
                    Objects.equals(dictName, dict.dictName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dictName, score);
        }
    }

    /**
     * 查找在排名范围内的字典数据
     *
     * @param low
     * @param high
     * @return
     */
    public List<String> zrange(int low, int high) {
        //1. 从最高层往第0层遍历累加span(rank),找到rank等于low的节点target，
        //2. 遍历第0层的target往后的 high - low

        SkipListNode curNode = this.head;
        SkipListNode next;
        int rank = 0;

        for (int i = level; i >= 0; i--) {

            next = curNode.getPointers()[i].getNext();
            while (next != null && (rank + curNode.getPointers()[i].getSpan()) <= low) {
                rank += curNode.getPointers()[i].getSpan();
                curNode = next;
                next = curNode.getPointers()[i].getNext();
            }

            if (rank == low) {
                break;
            }
        }

        List<String> res = new ArrayList<>();
        res.add(curNode.getDictName());
        for (int i = low; i < high; i++) {
            SkipListNode next1 = curNode.getPointers()[0].getNext();
            if (next1 == null) {
                break;
            }

            curNode = next1;
            res.add(curNode.getDictName());
        }

        return res;
    }

    /**
     * 查找在分数内的字典数据
     *
     * @param low
     * @param high
     * @return
     */
    public List<String> zrevrangebyscore(int low, int high) {
        return new ArrayList<>();
    }
}
