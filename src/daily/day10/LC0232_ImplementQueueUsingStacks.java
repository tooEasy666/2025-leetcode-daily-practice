package daily.day10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 232 - Implement Queue using Stacks
 * Tags: Stack, Design, Queue
 * 思路：用两个栈，一个负责入队（inStack），一个负责出队（outStack）。
 * 出队时如果 outStack 为空，则将 inStack 所有元素倒入 outStack。
 */
public class LC0232_ImplementQueueUsingStacks {
    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek(); // ensure outStack is not empty
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}