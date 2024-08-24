package org.learn.arrays;

/**
 * 螺旋矩阵II
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/description/">螺旋矩阵II</a>
 *
 * @author holly
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 螺旋矩阵II
     *
     * @param n 输入矩阵的维度
     * @return 返回结果矩阵
     */
    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        //每一圈的起点
        int startX = 0;
        int startY = 0;

        int offset = 1;
        //矩阵中需要填写的数字
        int count = 1;
        //记录当前的圈数
        int loop = 1;
        //j代表列，i代表行
        int i, j;

        while (loop <= n / 2) {
            //顶部
            //左闭右开，所以判断循环结束，j 不能等于n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startY][j] = count++;
            }

            //右列
            //左闭右开，所以判断循环结束时，i 不能等于n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            //底部
            //左闭右开，所以判断循环结束时，j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            //左列
            //左闭右开，所以判断循环结束时，i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
}
