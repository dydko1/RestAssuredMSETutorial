package lesson.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] numbers = {10, 15, 50, 30, 54, 21, 5};
        Integer target = 15;
        int[] nu = twoSum(numbers, target);
        System.out.println(nu[0]+ " "+nu[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }
}
