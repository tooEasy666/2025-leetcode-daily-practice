package daily.day27;

public class LC_0376_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int prevDiff = nums[1] - nums[0];
        int count = prevDiff != 0 ? 2 : 1;

        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = diff;
            }
        }

        return count;
    }
}
