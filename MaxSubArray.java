// 53. Maximum Subarray
//Brute Force Approach
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            int eachSum = nums[i];
            if (max < eachSum)
                max = eachSum;

            for (int j = i + 1; j < nums.length; j++) {
                eachSum += nums[j];
                if (eachSum > max)
                    max = eachSum;

            }

        }
        return (int) max;

    }
}
