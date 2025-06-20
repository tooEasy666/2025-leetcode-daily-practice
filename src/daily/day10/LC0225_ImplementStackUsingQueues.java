package daily.day10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 225 - Implement Stack using Queues
 * Tags: Stack, Design, Queue
 * 思路：使用一个队列实现栈，push 时把新元素放队尾，再将前面的元素转到后面，保证队首为栈顶
 */
public class LC0225_ImplementStackUsingQueues {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size-- > 1) {
            q.offer(q.poll()); // rotate to back
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}