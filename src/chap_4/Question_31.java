package chap_4;

import java.util.Stack;

/**
 * Created by Citrix on 2019-01-10.
 */
public class Question_31 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || popA.length == 0 || pushA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < popA.length) {
            while (pushIndex < pushA.length && (stack.isEmpty() || stack.peek() != popA[popIndex])) {
                stack.push(pushA[pushIndex]);//注意这里是whlie，条件还很多样
                pushIndex++;
            }
            if (stack.peek() == popA[popIndex]) {//先压入栈，然后判断栈顶
                stack.pop();
                popIndex++;
            } else {
                return false;
            }
        }
        return true;
    }
}
