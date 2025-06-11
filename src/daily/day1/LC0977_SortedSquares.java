package daily.day1;

/**
 * LeetCode 977 - Squares of a Sorted Array
 * Difficulty: easy
 * Tags: Two Pointers, Array
 * CN URL: https://leetcode.cn/problems/squares-of-a-sorted-array/
 * URL: https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Approach & 思路:
 * - 双指针，从两端往中间比较
 * - 比较nums[l]^2 和 nums[r]^2 哪个大，谁大移谁到数组最后， 移动完后改编指针，左加加右减减
 */


public class LC0977_SortedSquares {

    public int[] solution(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int j = nums.length - 1;

        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[j--] = nums[l] * nums[l++];
            } else {
                res[j--] = nums[r] * nums[r--];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC0977_SortedSquares sol = new LC0977_SortedSquares();
        int[] input = {-4, -1, 0, 3, 10};
        int[] output = sol.solution(input);

        System.out.print("Result: ");
        for (int num : output) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: 0 1 9 16 100
    }
}
