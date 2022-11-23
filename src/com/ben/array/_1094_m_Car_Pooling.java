package com.ben.array;

import com.ben.util.PrintUtil;


public class _1094_m_Car_Pooling {
    public static void main(String[] args) {
        int[][] trips = new int[][]{
                {2, 1, 5},
                {3, 5, 7}
        };

        PrintUtil.printLn(new Solution().carPooling(trips, 3));
    }

    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int maxStop = 0;
            for (int[] trip : trips) {
                maxStop = Math.max(maxStop, trip[2]);
            }
            int[] nums = new int[maxStop];

            for (int[] trip : trips) {
                int val = trip[0];
                int start = trip[1];
                int end = trip[2];

                nums[start] += val;

                if (end < maxStop) {
                    nums[end] -= val;
                }
            }

            if (nums[0] > capacity) {
                return false;
            }

            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i] + nums[i - 1];
                if (nums[i] > capacity) {
                    return false;
                }
            }

            return true;
        }
    }
}
