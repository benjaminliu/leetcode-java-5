package com.ben.array;

public class _0370_m_Range_Addition {

    class Solution {
        int[] getModifiedArray(int length, int[][] updates) {
            int[] nums = new int[length];
            Difference df = new Difference(nums);

            for (int[] update : updates) {
                int i = update[0];
                int j = update[1];
                int val = update[2];

                df.increment(i, j, val);
            }

            return df.result();
        }
    }

    //差分数组
    //https://labuladong.github.io/algo/2/20/25/
    public class Difference {

        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            // 根据差分数组构造结果数组
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
