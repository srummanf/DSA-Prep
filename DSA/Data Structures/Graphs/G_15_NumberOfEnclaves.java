// Similar to the problem of surrounded regions, we can solve the problem of counting the number of enclaves in a 2D grid. An enclave is defined as a group of connected land cells (0's) that are completely surrounded by water cells (1's) and cannot reach the boundary of the grid.

/** Problem Statement: Given a 2D grid of 0's (land) and 1's (water), count the number of enclaves. An enclave is a group of connected 0's that are completely surrounded by 1's and cannot reach the boundary of the grid.
 * Example:
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Intuition: The idea is to traverse the boundary of the grid and mark all land cells (0's) that are connected to the boundary. 
 * Then, we can iterate through the grid and count all unmarked land cells (0's), as they are enclaves.
 */

class G_15_NumberOfEnclaves{
    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        // Check Top and Bottom boundaries
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 1) {
                dfs(0, j, board, vis);
            }

            if (board[m - 1][j] == 1) {
                dfs(m - 1, j, board, vis);
            }
        }

        // Check Left and Right boundaries
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 1) {
                dfs(i, 0, board, vis);
            }

            if (board[i][n - 1] == 1) {
                dfs(i, n - 1, board, vis);
            }
        }

        int cantMoveOut = 0;
        // Convert surrounded O's to X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 1 && !vis[i][j]) {
                    cantMoveOut++;
                }
            }
        }

        return cantMoveOut;
    }



    void dfs(int i, int j, int[][] board, boolean[][] vis) {
        int rows = board.length;
        int cols = board[0].length;

        // Out of bounds, not O, or already visited
        if (i < 0 || i >= rows
                || j < 0 || j >= cols
                || board[i][j] != 1
                || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        // Down
        dfs(i + 1, j, board, vis);

        // Up
        dfs(i - 1, j, board, vis);

        // Right
        dfs(i, j + 1, board, vis);

        // Left
        dfs(i, j - 1, board, vis);
    }

    public static void main(String[] args) {
        G_15_NumberOfEnclaves obj = new G_15_NumberOfEnclaves();
        int[][] board = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int result = obj.numEnclaves(board);
        System.out.println("Number of enclaves: " + result); // Output: Number of enclaves: 3
    }
}