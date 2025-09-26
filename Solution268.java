//Uses a Hash Map to map indices to values which is iterated
//through to find a mismatch to indicate the missing number
public class Solution268 {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int i = 0; i < nums.length; i++) {
                map.put(i, nums[i]);
            }
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if (!entry.getKey().equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
            return nums.length;
        }
    }
}