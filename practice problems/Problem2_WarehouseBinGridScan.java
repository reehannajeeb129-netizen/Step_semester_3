public class Problem2_WarehouseBinGridScan {
    static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxValue = -1;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[] {total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        int[] r = warehouseSummary(grid);
        System.out.println("total = " + r[0] + ", maxCoordinate = (" + r[1] + ", " + r[2] + ")");
    }
}
