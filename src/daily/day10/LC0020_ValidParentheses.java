package daily.day10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 20 - Valid Parentheses
 * Tags: Stack, String
 * 思路：使用栈判断括号匹配
 */
public class LC0020_ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '[') stack.push(']');
            else if (ch == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != ch) return false;
        }
        return stack.isEmpty();
    }
}