package daily.day6;

/**
 * LeetCode 0242 - ValidAnagram
 * Difficulty: easy
 * Tags: 
 * CN URL: https://leetcode.cn/problems/valid-anagram
 * URL: https://leetcode.com/problems/valid-anagram
 *
 * Approach & 思路:
 * - 利用字符的ASCII，c - 'a'
 */

public class LC0242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        for (int i = 0; i < charCount.length; i++){
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
