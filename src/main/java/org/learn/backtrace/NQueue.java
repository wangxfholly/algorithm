package org.learn.backtrace;

import java.util.*;

/**
 * n皇后问题，递归解决
 *
 * @author holly
 */
public class NQueue {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(n, 0, board);
        return res;
    }

    public void backtrack(int n, int row, char[][] board) {
        if (row == n) {
            res.add(Array2List(board));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isValid(row, col, n, board)) {
                board[row][col] = 'Q';
                backtrack(n, row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(new String(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] board) {
        //检查列
        for (int i = 0; i < n; i++) {//相当于剪枝
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
