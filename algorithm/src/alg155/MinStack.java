package alg155;

import java.util.Stack;

/**最小栈
 * @author LaZY(李志一)
 * @create 2019-04-18 20:10
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min.push(min.isEmpty() ? x : Math.min(min.peek(), x));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        Integer peek = null;
        peek = stack.peek();
        return peek;
    }

    public int getMin() {
        Integer integer = null;
        integer = min.peek();
        return integer;
    }
}
