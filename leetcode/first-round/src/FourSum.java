import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) return null;
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        do left++; while(left < right && nums[left] == nums[left - 1]);
                        do {
                        	right--; 
                        } while(left < right && nums[right] == nums[right + 1]);
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return resultList;
    }
    public static void main(String args[]) {
    	int input [] = {0, 0, 0, 0};
    	fourSum(input, 0);
    }
}
