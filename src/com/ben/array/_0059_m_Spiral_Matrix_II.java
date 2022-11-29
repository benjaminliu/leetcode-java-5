package com.ben.array;

public class _0059_m_Spiral_Matrix_II {

    class Solution {
        public int[][] generateMatrix(int n) {
            int totalCount = n * n;

            int rowStart = 0;
            int rowEnd = n - 1;
            int colStart = 0;
            int colEnd = n - 1;

            int num = 1;

            int[][] res = new int[n][n];

            while (num <= totalCount) {
                if (rowStart <= rowEnd) {
                    for (int j = colStart; j <= colEnd; j++) {
                        res[rowStart][j] = num;
                        num++;
                    }
                    rowStart++;
                }

                if (colStart <= colEnd) {
                    for (int i = rowStart; i <= rowEnd; i++) {
                        res[i][colEnd] = num;
                        num++;
                    }
                    colEnd--;
                }

                if (rowStart <= rowEnd) {
                    for (int j = colEnd; j >= colStart; j--) {
                        res[rowEnd][j] = num;
                        num++;
                    }
                    rowEnd--;
                }

                if (colStart <= colEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        res[i][colStart] = num;
                        num++;
                    }
                    colStart++;
                }
            }

            return res;
        }
    }
}
