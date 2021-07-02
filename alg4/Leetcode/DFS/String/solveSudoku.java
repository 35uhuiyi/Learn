package alg4.Leetcode.DFS.String;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/29 21:09
 */
public class solveSudoku {

    public void f(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] gridUsed = new boolean[3][3][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]!='.'){
                    int num = board[i][j]-'0';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    gridUsed[i/3][j/3][num] = true;
                }
            }
        }
        dfs(board,rowUsed,colUsed,gridUsed,0,0);
    }

    /**
     *
     * @param board
     * @param rowUsed
     * @param colUsed
     * @param gridUsed
     * @param col 当前处理的列
     */
    boolean dfs(char[][] board, boolean[][] rowUsed,boolean[][] colUsed,boolean[][][] gridUsed,int row, int col){
        if(col==board[0].length){
            col = 0;
            row++;
            if(row==board.length){
                return true;  //填充完成
            }
        }
        if(board[row][col]=='.'){
            for (int i = 1; i <= 9; i++) {
                if((!rowUsed[row][i]&&!colUsed[col][i]&&!gridUsed[row/3][col/3][i])){
                    rowUsed[row][i] = true;
                    colUsed[col][i] = true;
                    gridUsed[row / 3][col / 3][i] = true;
                    board[row][col] = (char)(i+'0');
                    boolean ans = dfs(board, rowUsed, colUsed, gridUsed, row, col + 1);
                    if(ans){
                        return true;//可以放下，不回溯
                    }
                    board[row][col] = '.';
                    rowUsed[row][i] = false;
                    colUsed[col][i] = false;
                    gridUsed[row / 3][col / 3][i] = false;
                }
            }
        }else {
           return dfs(board,rowUsed,colUsed,gridUsed,row,col+1);
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku solveSudoku = new solveSudoku();
        solveSudoku.f(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }

        Deque<Integer> A = new LinkedList<>();

    }
}
