/**
 * Problem Statement:
 * Given a 2D grid of 0's (water) and 1's (land),
 * count the number of distinct islands.
 * Two islands are considered distinct if they have different shapes.
 *
 * Example:
 * Input:
 * [[1,1,0,0,0],
 *  [1,0,0,1,1],
 *  [0,0,0,1,1],
 *  [0,1,0,0,0]]
 *
 * Output: 2
 *
 * Intuition:
 * The idea is to traverse each island and record its shape
 * relative to a base coordinate.
 *
 * For every cell of an island:
 *
 *     relativeRow = currentRow - baseRow
 *     relativeCol = currentCol - baseCol
 *
 * Islands with the same shape will have the same relative coordinates.
 * We store each shape in a Set so duplicate shapes are automatically removed.
 */

import java.util.*;

class G_16_NumberOfDistinctIslands {

    public int countDistinctIslands(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        // Stores unique island shapes
        HashSet<List<List<Integer>>> set = new HashSet<>();

        // Traverse the entire grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Found a new island
                if (grid[i][j] == 1 && !vis[i][j]) {

                    // Store the shape of this island
                    List<List<Integer>> shape = new ArrayList<>();

                    // Current cell is the base/start cell
                    int baseRow = i;
                    int baseCol = j;

                    dfs(
                        i,
                        j,
                        baseRow,
                        baseCol,
                        grid,
                        vis,
                        shape
                    );

                    // Add this island's shape to Set
                    set.add(shape);
                }
            }
        }

        return set.size();
    }


    void dfs(
        int row,
        int col,
        int baseRow,
        int baseCol,
        int[][] grid,
        boolean[][] vis,
        List<List<Integer>> shape
    ) {

        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        // OR water
        // OR already visited
        if (row < 0 || row >= m ||
            col < 0 || col >= n ||
            grid[row][col] == 0 ||
            vis[row][col]) {

            return;
        }

        // Mark current cell visited
        vis[row][col] = true;


        // -----------------------------------
        // Store normalized coordinate
        // -----------------------------------

        int relativeRow = row - baseRow;
        int relativeCol = col - baseCol;

        List<Integer> coordinate = new ArrayList<>();

        coordinate.add(relativeRow);
        coordinate.add(relativeCol);

        shape.add(coordinate);


        // -----------------------------------
        // DFS in fixed order
        // -----------------------------------

        // Right
        dfs(
            row,
            col + 1,
            baseRow,
            baseCol,
            grid,
            vis,
            shape
        );

        // Down
        dfs(
            row + 1,
            col,
            baseRow,
            baseCol,
            grid,
            vis,
            shape
        );

        // Left
        dfs(
            row,
            col - 1,
            baseRow,
            baseCol,
            grid,
            vis,
            shape
        );

        // Up
        dfs(
            row - 1,
            col,
            baseRow,
            baseCol,
            grid,
            vis,
            shape
        );
    }


    public static void main(String[] args) {

        G_16_NumberOfDistinctIslands sol =
            new G_16_NumberOfDistinctIslands();

        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0}
        };

        int distinctIslands =
            sol.countDistinctIslands(grid);

        System.out.println(
            "Number of distinct islands: "
            + distinctIslands
        );
    }
}
