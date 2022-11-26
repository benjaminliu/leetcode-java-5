package com.ben.array;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0054_m_Spiral_Matrix {

    public static void main(String[] args) {
        int[][] matrics = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        PrintUtil.printList(new Solution().spiralOrder(matrics));
    }

    static class Solution {
        private int direction;

        public List<Integer> spiralOrder(int[][] matrix) {
            direction = 0;
            int rowStart = 0;
            int colStart = 0;
            int rowEnd = matrix.length - 1;
            int colEnd = matrix[0].length - 1;

            int totalCount = matrix.length * matrix[0].length;

            int count = 0;
            int i = 0;
            int j = 0;

            List<Integer> res = new ArrayList<>(totalCount);

            while (count < totalCount) {
                res.add(matrix[i][j]);
                count++;

                if (toRight()) {
                    //to right
                    if (j + 1 > colEnd) {
                        changeDirection();
                        rowStart++;
                        i++;
                    } else {
                        j++;
                    }
                } else if (toBottom()) {
                    //to bottom
                    if (i + 1 > rowEnd) {
                        changeDirection();
                        colEnd--;
                        j--;
                    } else {
                        i++;
                    }
                } else if (toLeft()) {
                    //to left
                    if (j - 1 < colStart) {
                        changeDirection();
                        rowEnd--;
                        i--;
                    } else {
                        j--;
                    }
                } else {
                    //to top
                    if (i - 1 < rowStart) {
                        changeDirection();
                        colStart++;
                        j++;
                    } else {
                        i--;
                    }
                }
            }
            return res;
        }

        private void changeDirection() {
            direction = (direction + 1) % 4;
        }

        private boolean toRight() {
            return direction == 0;
        }

        private boolean toBottom() {
            return direction == 1;
        }

        private boolean toLeft() {
            return direction == 2;
        }
    }


    static class Solution2 {

        public List<Integer> spiralOrder(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            int upperBound = 0;
            int lowerBound = row - 1;
            int leftBound = 0;
            int rightBound = col - 1;

            int totalCount = row * col;
            List<Integer> res = new ArrayList<>(totalCount);

            while (res.size() < totalCount) {
                if (upperBound <= lowerBound) {
                    //to right
                    for (int j = leftBound; j <= rightBound; j++) {
                        res.add(matrix[upperBound][j]);
                    }
                    upperBound++;
                }

                if (leftBound <= rightBound) {
                    //to bottom
                    for (int i = upperBound; i <= lowerBound; i++) {
                        res.add(matrix[i][rightBound]);
                    }
                    rightBound--;
                }

                if (upperBound <= lowerBound) {
                    //to left
                    for (int j = rightBound; j >= leftBound; j--) {
                        res.add(matrix[lowerBound][j]);
                    }
                    lowerBound--;
                }

                if (leftBound <= rightBound) {
                    //to top
                    for (int i = lowerBound; i >= upperBound; i--) {
                        res.add(matrix[i][leftBound]);
                    }
                    leftBound++;
                }
            }

            return res;
        }
    }
}
