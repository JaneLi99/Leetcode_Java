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

    public List<List<Integer>> threeSumBetterWay(int[] nums) {
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    List<Integer> subResult = List.of(nums[i], nums[j], nums[k]);
                    if (!result.contains(subResult)) {
                        result.add(subResult);
                    }
                    j ++;
                    k --;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    j ++;
                } else {
                    k --;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumBestWay (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        sorted list: {-4, -1, -1, 0, 1, 2}
        System.out.println(sol.threeSumBestWay(nums)); // Expected: [[-1, -1, 2], [-1, 0, 1]]
    }

}
