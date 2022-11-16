package com.ben.array;

import com.ben.util.PrintUtil;

import java.util.stream.IntStream;

public class _0167_m_Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;

        int[] nums = new int[]{-1, 0};
        int target = -1;

        PrintUtil.printArray(new Solution().twoSum(nums, target));
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {

            int last = numbers[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                int remain = target - numbers[i];
                if (remain > last) {
                    continue;
                }

                int leftIdx = i + 1;
                int rightIdx = numbers.length - 1;

                while (leftIdx <= rightIdx) {
                    int midIdx = (leftIdx + rightIdx) / 2;
                    int mid = numbers[midIdx];
                    if (remain == mid) {
                        return new int[]{i + 1, midIdx + 1};
                    }

                    if (remain < mid) {
                        rightIdx = midIdx - 1;
                    } else {
                        leftIdx = midIdx + 1;
                    }
                }
            }
            return new int[2];
        }
    }

    class Solution2 {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                }
                if (target < sum) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            }

            return new int[2];
        }
    }
}
