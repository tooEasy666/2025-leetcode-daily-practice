package daily.day8;

/**
 * LeetCode 0344 - ReverseString
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/reverse-string
 * URL: https://leetcode.com/problems/reverse-string
 *
 * Approach & 思路:
 * -
 */

public class LC0344_ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
