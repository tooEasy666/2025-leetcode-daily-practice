package daily.day1;

/**
 * LeetCode 27 - Remove Element
 * Difficulty: easy
 * Tags: Array, Two Pointers
 * CN URL: https://leetcode.cn/problems/remove-element
 * URL: https://leetcode.com/problems/remove-element
 *
 * Approach & 思路:
 * - 两个指针，fast来遍历每个元素，slow表示下一个应该“保留”的位置
 * - 遍历数组时，如果nums[fast] != val, 说明要保留此元素，否则跳过（移除）
 * - 最后返回slow，表示新数组的长度， nums[0] ~ nums[slow-1] 是保留下来的元素
 */

public class LC0027_RemoveElement {

    public int solution(int[] nums, int val) {

        //nums = [3,2,2,3], val = 3
        //        s
        //          f
        //nums = [2,3,2,3], val = 3
        //          s
        //            f
        //nums = [2,2,3,3], val = 3
        //            s
        //              f

        // nums = [0,1,2,2,3,0,4,2], val = 2
        //             s
        //                 f
        // nums = [0,1,3,2,2,0,4,2], val = 2
        //               s
        //                   f
        // nums = [0,1,3,0,2,2,4,2], val = 2
        //                 s
        //                     f
        // nums = [0,1,3,0,4,2,2,2], val = 2
        //                   s
        //                       f

        // two pointers, fast and slow both start from the beginning.
        // said the pointer poitns to a val equals to the val, slow stops, fast++ until finds one not equal to val
        // swap, then slow++, fast++ until fast hits the end, return s-1
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        LC0027_RemoveElement sol = new LC0027_RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = sol.solution(nums, val);
        System.out.println("New length: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) System.out.print(nums[i] + " ");
    }
}
