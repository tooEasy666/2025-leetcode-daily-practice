package daily.day51;

import java.util.LinkedList;
import java.util.Queue;

public class LC_0200_NumOfIslands {
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        grid[startR][startC] = '0';
        q.offer(new int[]{startR, startC});

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + DR[k];
                int nc = c + DC[k];
                if (isValid(grid, nr, nc)) {
                    grid[nr][nc] = '0'; // mark visited
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private boolean isValid(char[][] grid, int r, int c) {
        return r >= 0 && c >= 0 &&
                r < grid.length && c < grid[0].length &&
                grid[r][c] == '1';
    }

    //dfs version
//    private static final int[] DR = {1, -1, 0, 0};
//    private static final int[] DC = {0, 0, 1, -1};
//
//    public int numIslands(char[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int count = 0;
//        for (int r = 0; r < m; r++) {
//            for (int c = 0; c < n; c++) {
//                if (grid[r][c] == '1') {
//                    dfs(grid, r, c);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private void dfs(char[][] grid, int startR, int startC) {
//        if (!isValid(grid, startR, startC)) {
//            return;
//        }
//
//        grid[startR][startC] = '0';
//
//        for (int k = 0; k < 4; k++) {
//            int nr = startR + DR[k];
//            int nc = startC + DC[k];
//            dfs(grid, nr, nc);
//        }
//        return;
//    }
//
//    private boolean isValid(char[][] grid, int r, int c) {
//        return r >= 0 && c >= 0 &&
//                r < grid.length && c < grid[0].length &&
//                grid[r][c] == '1';
//    }
}
