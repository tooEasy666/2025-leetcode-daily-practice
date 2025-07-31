package daily.day51;

public class LC_0695_MaxAreaOfIsland {
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        // cc
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfsCalArea(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int dfsCalArea(int i, int j, int[][]grid) {
        if (!isValidCor(i, j, grid)) {
            return 0;
        }

        grid[i][j] = 0;
        int curArea = 1;   // 当前格子面积

        for (int k = 0; k < 4; k++) {
            int nr = i + DR[k];
            int nc = j + DC[k];
            curArea += dfsCalArea(nr, nc, grid);
        }
        return curArea;

    }

    private boolean isValidCor(int i, int j, int[][]grid) {
        return (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1);
    }
}
