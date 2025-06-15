package daily.day6;

/**
 * LeetCode 0202 - HappyNumber
 * Difficulty: easy
 * Tags: 
 * CN URL: https://leetcode.cn/problems/happy-number
 * URL: https://leetcode.com/problems/happy-number
 *
 * Approach & 思路:
 * - Floyd 判圈只需要常数空间，且数学上一定能找到环；
 * - 因此，在所有判循环的题目中，快慢指针都是更优方式。
 *
 * 假设这个数列会产生一个环，那么就等价于「链表是否有环的问题」。我们让两个指针同时在“数值链”上前进：
 * - slow 指针每次走一步（计算一次 sum of squares）
 * - fast 指针每次走两步（计算两次 sum of squares）
 * 两种可能：
 * - fast 指针先到达了 1，说明是快乐数；
 * - slow 和 fast 最终相遇在环中某一点，说明不是快乐数（进入死循环）
 */

public class LC0202_HappyNumber {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
