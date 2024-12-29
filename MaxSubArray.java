// 53. Maximum Subarray
//Brute Force Approach
// class MaxSubArray {
//     public int maxSubArray(int[] nums) {
//         double max = Double.NEGATIVE_INFINITY;
//         for (int i = 0; i < nums.length; i++) {
//             int eachSum = nums[i];
//             if (max < eachSum)
//                 max = eachSum;

//             for (int j = i + 1; j < nums.length; j++) {
//                 eachSum += nums[j];
//                 if (eachSum > max)
//                     max = eachSum;

//             }

//         }
//         return (int) max;

//     }
// }

//Optimized using Kadane's algo
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        double negInfinity = Double.NEGATIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        List<Double> currentSum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            double prevSum = currentSum.isEmpty()? negInfinity: currentSum.get(i - 1);
            double current = Math.max(nums[i], prevSum + nums[i]);
            currentSum.add(current);
            if(current > max ) max = current;

        }
        return (int) max;

    }
}
