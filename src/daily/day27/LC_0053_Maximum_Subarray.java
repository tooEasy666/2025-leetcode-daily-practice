package daily.day27;

public class LC_0053_Maximum_Subarray {
    // Kadane算法
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            globalMax = Math.max(globalMax, currMax);
        }

        return globalMax;
    }
}
