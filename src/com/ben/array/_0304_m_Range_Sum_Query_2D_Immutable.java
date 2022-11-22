package com.ben.array;

import com.ben.util.PrintUtil;

public class _0304_m_Range_Sum_Query_2D_Immutable {

    public static void main(String[] args) {
        int[][] metrics = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}

        };

        NumMatrix numMatrix = new NumMatrix(metrics);

        PrintUtil.printLn(numMatrix.sumRegion(2, 1, 4, 3));
        PrintUtil.printLn(numMatrix.sumRegion(1, 1, 2, 2));
        PrintUtil.printLn(numMatrix.sumRegion(1, 2, 2, 4));
    }

    static class NumMatrix {

        private int[][] board;

        public NumMatrix(int[][] matrix) {
            board = new int[matrix.length + 1][matrix[0].length + 1];

            for (int i = 1; i < board.length; i++) {
                for (int j = 1; j < board[0].length; j++) {
                    board[i][j] = board[i][j - 1] + matrix[i - 1][j - 1];
                }
            }

            for (int j = 1; j < board[0].length; j++) {
                for (int i = 1; i < board.length; i++) {
                    board[i][j] = board[i][j] + board[i - 1][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return board[row2 + 1][col2 + 1] + board[row1][col1] - board[row2 + 1][col1] - board[row1][col2 + 1];
        }
    }
}
