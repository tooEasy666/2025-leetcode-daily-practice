package daily.day8;

/**
 * LeetCode 0541 - ReverseStringII
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/reverse-string-ii
 * URL: https://leetcode.com/problems/reverse-string-ii
 *
 * Approach & 思路:
 * -
 */

public class LC0541_ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int start = 0; start < s.length(); start += 2 * k) {
            int left = start;
            int right = Math.min(start + k - 1, s.length() - 1); // 不能越界
            reverse(chars, left, right);
        }

        return new String(chars);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
