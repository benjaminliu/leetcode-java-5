package com.ben.array;

public class _0026_e_Remove_Duplicates_from_Sorted_Array {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }

            int dupCount = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    dupCount++;
                } else {
                    if (dupCount > 0) {
                        nums[i - dupCount] = nums[i];
                    }
                }
            }

            return nums.length - dupCount;
        }
    }
}
