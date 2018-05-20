package QueueStack;

import java.util.Stack;

/**
 * Created by lqs on 2018/5/14.
 */
public class DoubleStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

//stack1作为push
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * pop的时候，如果stack2为空的话，就将stack1进行pop，然后全部push到stack2，stack2进行一次pop
     * 如果stack2不为空的话，则直接pop。
     * @return
     */
    public int pop() {
        if(stack2.isEmpty()){
            while (stack1.size() != 0) {
                Integer cur = stack1.pop();
                stack2.push(cur);
            }
        }
        return stack2.pop();
    }

}
