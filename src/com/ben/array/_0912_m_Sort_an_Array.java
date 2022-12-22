package com.ben.array;

public class _0912_m_Sort_an_Array {

    class Solution {
        public int[] sortArray(int[] nums) {
            tmp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        private int[] tmp;

        public void mergeSort(int[] nums, int lo, int hi) {
            if (lo >= hi) {
                return;
            }

            int mid = (lo + hi) / 2;

            mergeSort(nums, lo, mid);
            mergeSort(nums, mid + 1, hi);

            merge(nums, lo, mid, hi);
        }

        private void merge(int[] nums, int lo, int mid, int hi) {
            for (int i = lo; i <= mid; i++) {
                tmp[i] = nums[i];
            }

            int left = lo;
            int right = mid + 1;

            for (int i = lo; i <= hi; i++) {
                if (left > mid) {
                    //Left half has been merged
                    nums[i] = nums[right];
                    right++;
                } else if (right > hi) {
                    //Right half has been merged
                    nums[i] = tmp[left];
                    left++;
                } else if (tmp[left] <= nums[right]) {
                    nums[i] = tmp[left];
                    left++;
                } else {
                    nums[i] = nums[right];
                    right++;
                }
            }
        }
    }
}
