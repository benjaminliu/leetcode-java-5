package com.ben.array;

public class _0303_e_Range_Sum_Query_Immutable {

    class NumArray {

        private int[] sums;
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == right) {
                return nums[left];
            }

            return sums[right] - sums[left] + nums[left];
        }
    }

    class NumArray2 {
        // 前缀和数组
        private int[] preSum;

        /* 输入一个数组，构造前缀和 */
        public NumArray2(int[] nums) {
            // preSum[0] = 0，便于计算累加和
            preSum = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        /* 查询闭区间 [left, right] 的累加和 */
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
