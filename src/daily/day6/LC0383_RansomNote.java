package daily.day6;

/**
 * LeetCode 0383 - RansomNote
 * Difficulty: easy
 * Tags:
 * CN URL: https://leetcode.cn/problems/ransom-note
 * URL: https://leetcode.com/problems/ransom-note
 *
 * Approach & 思路:
 * -
 */

public class LC0383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charFreq = new int[26];

        for (char c : magazine.toCharArray()) {
            charFreq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            charFreq[c - 'a']--;
        }

        for (int j : charFreq) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }
}

