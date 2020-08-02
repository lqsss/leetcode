package structure.skiplist;

/**
 * 跳表中的节点
 *
 * @author lqs
 * @version 1.0
 * @date 2020/7/26 12:57 下午
 */
public class SkipListNode {

    /**
     * 具体数值
     */
    private int score;

    /**
     * 只有最低层是双向链表
     */
    private SkipListNode prev;

    private String dictName;

    /**
     * 包含的指针节点，该数组从0开始，代表第0级
     */
    private Pointer[] pointers;

    public SkipListNode(int level) {
        pointers = new Pointer[level];
        for (int i = 0; i < level; i++) {
            pointers[i] = new Pointer();
        }
    }

    public SkipListNode(int score, int level, String dictName) {
        this(level);
        this.score = score;
        this.dictName = dictName;
    }


    static class Pointer {
        /**
         * 指向下一个节点
         */
        private SkipListNode next;

        /**
         * 跨度,包含指向的节点
         * 比如:head->第一个节点，此时跨度为1
         */
        private int span;

        public SkipListNode getNext() {
            return next;
        }

        public void setNext(SkipListNode next) {
            this.next = next;
        }

        public int getSpan() {
            return span;
        }

        public void setSpan(int span) {
            this.span = span;
        }

        public Pointer(SkipListNode next) {
            this.next = next;
        }

        public Pointer() {
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public SkipListNode getPrev() {
        return prev;
    }

    public void setPrev(SkipListNode prev) {
        this.prev = prev;
    }

    public Pointer[] getPointers() {
        return pointers;
    }

    public void setPointers(Pointer[] pointers) {
        this.pointers = pointers;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    @Override
    public String toString() {
        return "SkipListNode{" +
                "score=" + score +
                ", dictName='" + dictName + '\'' +
                '}';
    }
}
