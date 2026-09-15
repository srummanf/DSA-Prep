
/** We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

 *  *Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way. */

import java.util.*;

class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : dislikes) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // -1 = uncolored
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        // Handle disconnected graph
        for (int i = 1; i <= n; i++) {

            if (color[i] == -1) {

                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(
            int node,
            int col,
            int[] color,
            ArrayList<ArrayList<Integer>> adj
    ) {

        // Color current node
        color[node] = col;

        // Visit neighbors
        for (int neighbour : adj.get(node)) {

            // Uncolored
            if (color[neighbour] == -1) {

                if (!dfs(neighbour, 1 - col, color, adj)) {
                    return false;
                }
            } // Same color => not bipartite
            else if (color[neighbour] == color[node]) {
                return false;
            }
        }

        return true;
    }
}
