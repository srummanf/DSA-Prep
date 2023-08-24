import java.util.*;

public class code1 {

  // -------------------------------------- Graph Data Structure Creation ----------------------------------------------------------------
  static class Edge {

    int src, dest, weight;

    public Edge(int s, int d, int w) {
      src = s;
      dest = d;
      weight = w;
    }
  }

  // -------------------------------------- Graph Creation ----------------------------------------------------------------
  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    graph[0].add(new Edge(0, 2, 2));

    graph[1].add(new Edge(1, 2, 10));
    graph[1].add(new Edge(1, 3, 0));

    graph[2].add(new Edge(2, 0, 2));
    graph[2].add(new Edge(2, 1, 10));
    graph[2].add(new Edge(2, 3, -1));

    graph[3].add(new Edge(3, 1, 0));
    graph[3].add(new Edge(3, 2, -1));
  }

  // -------------------------------------- Breadth First Search BFS ----------------------------------------------------------------
  public static void BFS(
    ArrayList<Edge> graph[],
    int V,
    boolean visited[],
    int start
  ) {
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    while (!q.isEmpty()) {
      int curr = q.remove();
      if (visited[curr] == false) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          q.add(e.dest);
        }
      }
    }
  }

  // -------------------------------------- Depth First Search DFS ----------------------------------------------------------------
  public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]) {
    System.out.print(curr + " ");
    visited[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (visited[e.dest] == false) {
        DFS(graph, e.dest, visited);
      }
    }
  }

  // -------------------------------------- Source to Destination : all Paths  O{V*V}----------------------------------------------------------------
  public static void printAllPath(
    ArrayList<Edge> graph[],
    boolean visited[],
    int curr,
    String path,
    int tar
  ) {
    if (curr == tar) {
      System.out.println(path);
      return;
    }
    for (int i = 0; i < graph[curr].size(); i++) {
      {
        Edge e = graph[curr].get(i);
        if (visited[e.dest] == false) {
          visited[e.dest] = true;
          printAllPath(graph, visited, e.dest, path + e.dest, tar);
          visited[e.dest] = false;
        }
      }
    }
  }

  // -------------------------------------- Cycle Detection for Directed Graph ----------------------------------------------------------------

  // Condition : in DFS stack , if we get the node which is already in the stack then cycle is present

  public static boolean isCycleDetected(
    ArrayList<Edge> graph[],
    boolean vis[],
    int curr,
    boolean recstack[]
  ) {
    vis[curr] = true;
    recstack[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (recstack[e.dest]) {
        return true;
      } else if (!vis[e.dest]) {
        if (isCycleDetected(graph, vis, e.dest, recstack)) {
          return true;
        }
      }
    }
    recstack[curr] = false;

    return false;
  }

  // -------------------------------------- Cycle Detection for Undirected Graph ----------------------------------------------------------------
  

  // -------------------------------------- Main function ----------------------------------------------------------------
  public static void main(String[] args) {
    int V = 4;
    ArrayList<Edge> graph[] = new ArrayList[V];

    createGraph(graph);

    // print 2's neighbours
    for (int i = 0; i < graph[2].size(); i++) {
      Edge e = graph[2].get(i);
      System.out.println(e.src + " --> " + e.dest + " with weight " + e.weight);
    }

    boolean visited1[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (visited1[i] == false) {
        BFS(graph, V, visited1, i);
      }
    }

    System.out.println();
    boolean visited2[] = new boolean[V];
    DFS(graph, 0, visited2);

    printAllPath(graph, new boolean[V], 0, "0", 5);

    boolean vis[] = new boolean[V];
    boolean rec[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        boolean isCycle = isCycleDetected(graph, vis, 0, rec);
        if (isCycle) {
          System.out.println("Cycle is present");
          break;
        }
      }
    }
  }
}
