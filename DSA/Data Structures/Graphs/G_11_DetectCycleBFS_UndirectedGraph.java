
import java.util.*;

class G_11_DetectCycleBFS_UndirectedGraph {

    // ------------------------------------------------------------------------ CHECKING WHETHER CYCLE EXISTS OR NOT ---------------------------------------------------------------------------------------

    boolean BFS_CheckForCycle(int src, int V, ArrayList<ArrayList<Integer>> adjLs, boolean vis[]) {
        Queue<int[]> queue = new LinkedList<>();

        // {node, parent}
        queue.add(new int[]{src, -1});
        vis[src] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int par = current[1];
            for (int it : adjLs.get(node)) {
                if (vis[it] == false) {
                    queue.add(new int[]{it, node});
                    vis[it] = true;
                } else if (par != it) {
                    return true;
                }
            }
        }
        return false;
    }

    // For Multiple Components - Will just return whether cycle is present or not in any of the components
    boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjLs) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (BFS_CheckForCycle(i, V, adjLs, vis) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    // ------------------------------------------------------------------ RETURN THE NUMBER OF CYCLES -----------------------------------------------------------------------------------------------

    int BFS_CountCycles(
            int src,
            int V,
            ArrayList<ArrayList<Integer>> adjLs,
            boolean vis[]) {

        Queue<int[]> queue = new LinkedList<>();

        // {node, parent}
        queue.add(new int[]{src, -1});
        vis[src] = true;

        int cycleEdges = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int node = current[0];
            int par = current[1];

            for (int it : adjLs.get(node)) {

                if (vis[it] == false) {

                    // First time visiting this node
                    vis[it] = true;

                    queue.add(new int[]{it, node});

                }
                else if (par != it) {

                    // Visited neighbour which is not parent
                    cycleEdges++;
                }
            }
        }

        // Every undirected non-tree edge is encountered twice
        return cycleEdges / 2;
    }


    // For Multiple Components
    // Returns total number of independent cycles
    int countCycles(int V, ArrayList<ArrayList<Integer>> adjLs) {

        boolean vis[] = new boolean[V];

        int totalCycles = 0;

        for (int i = 0; i < V; i++) {

            if (vis[i] == false) {

                totalCycles += BFS_CountCycles(
                        i,
                        V,
                        adjLs,
                        vis
                );
            }
        }

        return totalCycles;
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Helper method for undirected graph
    static void addEdge(
            ArrayList<ArrayList<Integer>> adjLs,
            int u,
            int v) {

        adjLs.get(u).add(v);
        adjLs.get(v).add(u);
    }

    public static void main(String args[]) {
        int V = 10;

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        // Undirected edges
        addEdge(adjLs, 0, 1);
        addEdge(adjLs, 1, 2);
        addEdge(adjLs, 2, 3);
        addEdge(adjLs, 3, 0);
        addEdge(adjLs, 3, 4);
        addEdge(adjLs, 5, 6);
        addEdge(adjLs, 7, 8);
        addEdge(adjLs, 7, 9);
        addEdge(adjLs, 8, 9);



        G_11_DetectCycleBFS_UndirectedGraph obj
                = new G_11_DetectCycleBFS_UndirectedGraph();

        boolean result = obj.isCycle(V, adjLs);

        if (result) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("Cycle is NOT present");
        }

        int totalCycles = obj.countCycles(V, adjLs);
        System.out.println("Total number of independent cycles: " + totalCycles);
    }

}
