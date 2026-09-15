/** Bipartite Graph : A graph is bipartite if we can divide the vertices into two disjoint sets such that every edge connects a vertex from one set to another.
 * 2 nodes have alternate colors if they are connected by an edge. So, we can color the graph using 2 colors and check if any two adjacent nodes have the same color. If yes, then it is not a bipartite graph.
 * 
 */

// Any Graph with even cycle is bipartite and any graph with odd cycle is not bipartite.

import java.util.*;

class G_18_Bipartite_DFS {

  private boolean dfs(
    int node,
    int col,
    int color[],
    ArrayList<ArrayList<Integer>> adj
  ) {
    // Add color to the node
    color[node] = col;

    // traverse adjacent nodes
    for (int ngh : adj.get(node)) {
      // if uncoloured
      if (color[ngh] == -1) {
        if (dfs(ngh, 1 - col, color, adj) == false) return false;
      }
      // if previously coloured and have the same colour
      else if (color[ngh] == col) {
        return false;
      }
    }

    return true;
  }

  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
    int color[] = new int[V];
    Arrays.fill(color, -1);

    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        if (dfs(i, 0, color, adj) == false) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // V = 4, E = 4
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(0).add(2);
    adj.get(2).add(0);
    adj.get(0).add(3);
    adj.get(3).add(0);
    adj.get(1).add(3);
    adj.get(3).add(1);
    adj.get(2).add(3);
    adj.get(3).add(2);

    G_18_Bipartite_DFS obj = new G_18_Bipartite_DFS();
    boolean ans = obj.isBipartite(4, adj);
    if (ans) System.out.println("1"); else System.out.println("0");
  }
}
