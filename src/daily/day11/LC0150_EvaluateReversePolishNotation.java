package daily.day11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 150 - Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * Tags: Stack
 * CN URL: https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * URL: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Approach & 思路:
 * - 使用栈来模拟逆波兰表达式的求值过程
 * - 遇到数字就入栈，遇到操作符就弹出两个数字运算后入栈
 * - 注意除法与减法的顺序（先出栈是右操作数）
 */
public class LC0150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}