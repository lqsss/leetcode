package QueueStack;

import java.util.Stack;

/**
 * 需要一个存储min的辅助栈，保证栈顶一定是当前栈中最小的元素
 * Created by lqs on 2018/5/15.
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || node <= minStack.peek()) {
            minStack.push(node);
        }
    }

    public void pop() {
        Integer tmp = null;
        if (!stack.isEmpty()) {
            tmp = stack.pop();
        }
        if (tmp != null && tmp == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
