package daily.day9;

/**
 * LeetCode 151 - Reverse Words in a String
 * Difficulty: Medium
 * Tags: Two Pointers, String
 * CN URL: https://leetcode.cn/problems/reverse-words-in-a-string/
 * EN URL: https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * 思路：
 * - 三步反转法（经典解法）：
 *   1. 清理多余空格（首尾空格 & 多个空格 → 一个空格）
 *   2. 整体反转字符串
 *   3. 再逐个反转单词
 *
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */

public class LC0151_ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        char[] chars = s.toCharArray();

        // Step 1: 清除多余空格
        int newLength = removeExtraSpaces(chars);
        char[] trimmed = new char[newLength];
        System.arraycopy(chars, 0, trimmed, 0, newLength);

        // Step 2: 整体反转字符串
        reverse(trimmed, 0, trimmed.length - 1);

        // Step 3: 逐个单词反转
        reverseEachWord(trimmed);

        return new String(trimmed);
    }

    // 移除前后和中间多余空格，返回新长度
    private int removeExtraSpaces(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;

        while (j < n) {
            // 跳过开头空格
            while (j < n && chars[j] == ' ') j++;

            // 拷贝非空格部分
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }

            // 跳过中间空格，但只保留一个空格
            while (j < n && chars[j] == ' ') j++;
            if (j < n) chars[i++] = ' ';
        }
        return i;
    }

    // 翻转整个字符串或某段字符
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }

    // 翻转每个单词
    private void reverseEachWord(char[] chars) {
        int n = chars.length;
        int start = 0, end = 0;

        while (start < n) {
            // 找到单词结尾
            while (end < n && chars[end] != ' ') end++;

            // 翻转该单词
            reverse(chars, start, end - 1);

            // 移动到下一个单词
            start = end + 1;
            end = start;
        }
    }
}