// 15. 3Sum
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int need = target - nums[i] - nums[j];
                if (map.containsKey(need)) {
                    List<Integer> subList = Arrays.asList(need, nums[i], nums[j]);
                    Collections.sort(subList);
                    if (!results.contains(subList)) {
                        results.add(subList);
                    }
                }
                map.put(nums[j], j);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum(nums)); // Expected: [[-1, -1, 2], [-1, 0, 1]]
    }

}
