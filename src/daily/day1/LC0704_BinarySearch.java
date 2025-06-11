package daily.day1;

/**
 * LeetCode 704 - Binary Search
 * Difficulty: Easy
 * Tags: Binary Search
 * CN URL: https://leetcode.cn/problems
 * URL: https://leetcode.com/problems/binary-search/
 *
 * Approach & 思路:
 * - Classic binary search implementation (left <= right)
 * - Check mid, adjust left/right accordingly
 *
 *  假如想不起来怎么做了，或者怎么区分左右指针，可以用comment demo一下：
 *        // we wanted to return the index
 *         //1 <= nums.length <= 104
 *         // [-1,0,3,5,9,12], target = 9
 *         //  l           r
 *         //       m
 *         //         l
 *         //            m
 */

public class LC0704_BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Standard binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }

    // Optional: Local testing
    public static void main(String[] args) {
        LC0704_BinarySearch solution = new LC0704_BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(solution.search(nums, target)); // Output: 4
    }
}
