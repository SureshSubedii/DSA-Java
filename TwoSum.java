import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer ,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int val = target - nums[i];
            Integer index = map.get(val);
            if(index != null && index != i){
                indices[0] = index;
                indices[1] = i;
                return indices;
            }

        }
        return null;

    }
}