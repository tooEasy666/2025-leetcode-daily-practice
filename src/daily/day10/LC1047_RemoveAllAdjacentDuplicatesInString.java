package daily.day10;

/**
 * LeetCode 1047 - Remove All Adjacent Duplicates In String
 * Difficulty: Easy
 * Tags: Stack, String
 * CN URL: https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 * EN URL: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * 思路：
 * - 使用 StringBuilder 模拟字符栈。
 * - 遍历字符数组，如果当前字符和栈顶字符相同，则 pop（即删除栈顶元素）。
 * - 否则就 append（相当于 push）当前字符。
 * - 最终 sb.toString() 即为结果。
 *
 * 时间复杂度：O(n)，每个字符最多进出栈一次
 * 空间复杂度：O(n)，栈空间
 */
public class LC1047_RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1); // 模拟出栈
            } else {
                sb.append(c); // 模拟入栈
            }
        }
        return sb.toString();
    }

    // Optional: local test
    public static void main(String[] args) {
        LC1047_RemoveAllAdjacentDuplicatesInString solution = new LC1047_RemoveAllAdjacentDuplicatesInString();
        String input = "abbaca";
        System.out.println(solution.removeDuplicates(input)); // Expected: "ca"
    }
}