// 15. 3Sum
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int arrayLength = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int index = 0; index < arrayLength - 2; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            int left = index + 1;
            int right = arrayLength - 1;

            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
