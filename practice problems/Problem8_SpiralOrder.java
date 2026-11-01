import java.util.ArrayList;
import java.util.List;

public class Problem8_SpiralOrder {
    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0) {
            return result;
        }
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(grid[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(grid[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(grid[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(grid[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(spiralOrder(grid));
        System.out.println("Own test (non-square):");
        System.out.println(spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}}));
    }
}
