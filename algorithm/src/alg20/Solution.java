package alg20;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 *
 * 如果是左括号，压入栈中
 * 如果是右括号，栈顶弹出，检查是否相匹配，不匹配，直接返回false
 * 最后遍历完字符串后，检查栈是否为空，不为空，则返回false
 * @author LaZY(李志一)
 * @create 2019-03-05 10:03
 */
class Solution {

    private HashMap<Character, Character> mappings;

    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mappings.containsKey(c)) {

                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
