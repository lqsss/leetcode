package QueueStack;

import java.util.Stack;

/**
 * Created by lqs on 2018/5/14.
 */
public class IsPopOrder {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int ptrA = 0;
        //模拟入栈出栈
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && popA[ptrA] == stack.peek()) {
                stack.pop();
                ptrA++;
            }
        }
        return stack.isEmpty();
    }

/*        int ptrA = 0;
        int ptrB = 0;
        while (ptrA <= pushA.length - 1) {
            if (!stack.isEmpty()) {
                if (popA[ptrB] != stack.peek()) {
                    stack.push(pushA[ptrA++]);
                } else {
                    stack.pop();
                    ptrB++;
                }
            } else {
                stack.push(pushA[ptrA++]);
            }
        }
        while (ptrB <= popA.length - 1) {
            if (stack.peek() == popA[ptrB]) {
                stack.pop();
                ptrB++;
            }else{
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }*/


    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        IsPopOrder(pushA, popA);
    }
}
