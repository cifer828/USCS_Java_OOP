import java.util.*;


public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // if (i > 0 && nums[i] == nums[i - 1]) continue; // don't let same i appear twice
            int twoSum = -nums[i];
            Map<Integer, Integer>map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++){
                if (map.containsKey(twoSum - nums[j])) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[i]);
                    oneResult.add(nums[map.get(twoSum - nums[j])]);
                    oneResult.add(nums[j]);
                    list.add(oneResult);
                    // while (nums[j+1] == nums[j]) j++; // don't let same j appear twice
                }
                else
                    map.put(nums[j], j);
            }
        }
        return list;
    }
    public static void main(String args[]) {
    	int input [] = {-1, -1,- 2};
    	threeSum(input);
    }
}