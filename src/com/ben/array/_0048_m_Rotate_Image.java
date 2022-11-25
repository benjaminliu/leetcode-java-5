package com.ben.array;

public class _0048_m_Rotate_Image {

    class Solution {
        public void rotate(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int lastCol = col - 1;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j <= i; j++) {
                    swap(matrix, i, j, j, i);
                }
            }

            for (int i = 0; i < row; i++) {
                int left = 0;
                int right = lastCol;
                while (left < right) {
                    swap(matrix, i, left, i, right);
                    left++;
                    right--;
                }
            }
        }

        private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
            int tmp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = tmp;
        }
    }
}
