package daily.day2;
/**
 * LeetCode  - LC0059_SpiralMatrix2
 * Difficulty: medium
 * Tags: 2D-grid
 * CN URL: https://leetcode.cn/problems/spiral-matrix-ii
 * URL: https://leetcode.com/problems/spiral-matrix-ii
 *
 * Approach & 思路:
 * - straightforward solution, 暴力填充数组
 * - 有两个小技巧：
 * -- 1. 用一个二维数组代表方向，顺时针走右下左上：int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}}
 * -- 2. 用 dir = (dir + 1) % 4 来转方向，如果是逆时针则为： dir = (dir + 3) % 4
 *
 * 这类2D网格题目技巧其实在后面BFS DFS也会用到
 */

public class LC0059_SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // 右、下、左、上

        int row = 0, col = 0, dir = 0;

        for (int num = 1; num <= n * n; num++) {
            matrix[row][col] = num;

            int nextRow = row + dirs[dir][0];
            int nextCol = col + dirs[dir][1];

            // 如果越界或下一个位置已填过，就转方向
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                dir = (dir + 1) % 4;  // 顺时针转方向
                nextRow = row + dirs[dir][0];
                nextCol = col + dirs[dir][1];
            }

            row = nextRow;
            col = nextCol;
        }

        return matrix;
    }
}