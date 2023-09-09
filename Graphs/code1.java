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

  // -------------------------------------- Topological Sort : DAG Directed Acyclic Graph
  // It is the linear order of V such that every directed edge  u-> v, the vertex u comes before v in the order
  // we use DFS ----------------------------------------------------------------

  public static void topologicalSortUtil(
    ArrayList<Edge> graph[],
    int curr,
    boolean vis[],
    Stack<Integer> st
  ) {
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!vis[e.dest]) {
        topologicalSortUtil(graph, e.dest, vis, st);
      }
    }
    st.push(curr);
  }

  public static void topSort(ArrayList<Edge> graph[], int V) {
    boolean vis[] = new boolean[V];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        topologicalSortUtil(graph, i, vis, st);
      }
    }

    while (!st.isEmpty()) {
      System.out.print(st.pop() + " ");
    }
  }

  // -------------------------------------- Cycle Detection for Undirected Graph ----------------------------------------------------------------
  public static boolean isCycleUndirectedGraph(
    ArrayList<Edge> graph[],
    boolean vis[],
    int curr,
    int par
  ) {
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (vis[e.dest] && e.dest != par) {
        // System.out.println("Cycle is present");
        return true;
      } else if (!vis[e.dest]) {
        if (isCycleUndirectedGraph(graph, vis, e.dest, curr)) {
          return true;
        }
      }
    }
    return false;
  }

  // -------------------------------------- Shortest Path Algo - Dijkstra's Algo - Shortest distance between source to all the vertices - Greedy ----------------------------------------------------------------

  public static class Pair implements Comparable<Pair> {

    int node;
    int dist;

    public Pair(int n, int d) {
      this.node = n;
      this.dist = d;
    }

    @Override
    public int compareTo(Pair p2) {
      return this.dist - p2.dist; //ascending order  -- for descending order, p2.dist - this.dist
    }
  }

  public static void dijkstra(ArrayList<Edge> graph[], int src, int V) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    int dist[] = new int[V];
    for (int i = 0; i < V; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }
    boolean vis[] = new boolean[V];

    pq.add(new Pair(0, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      if (!vis[curr.node]) {
        vis[curr.node] = true;

        for (int i = 0; i < graph[curr.node].size(); i++) {
          Edge e = graph[curr.node].get(i);
          int u = e.src;
          int v = e.dest;
          if (dist[v] > dist[u] + e.weight) { // Relaxation Condition
            dist[v] = dist[u] + e.weight;
            pq.add(new Pair(v, dist[v]));
          }
        }
      }
      for (int i = 0; i < V; i++) {
        System.out.print(dist[i] + " ");
      }
      System.out.println();
    }
  }

  // -------------------------------------- Shortest Path Algo - Bellman Ford Algo - Shortest distance between source to all the vertices - DP -Use it for +/- weights ----------------------------------------------------------------

  public static void BellmanFord(ArrayList<Edge> graph[], int src, int V) {
    int dist[] = new int[V];
    for (int i = 0; i < V; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }
    for (int k = 0; k < V - 1; k++) { //O(V)
      //O(E)
      for (int i = 0; i < V; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
          Edge e = graph[i].get(j);
          int u = e.src;
          int v = e.dest;
          if (
            (dist[v] > dist[u] + e.weight) && (dist[u] != Integer.MAX_VALUE)
          ) { // Relaxation Condition
            dist[v] = dist[u] + e.weight;
          }
        }
      }
    }

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < graph[i].size(); j++) {
        Edge e = graph[i].get(j);
        int u = e.src;
        int v = e.dest;
        if ((dist[v] > dist[u] + e.weight) && (dist[u] != Integer.MAX_VALUE)) { // Relaxation Condition
          System.out.println("Negative Cycle is present");
        }
      }
    }

    for (int i = 0; i < dist.length; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }

  // -------------------------------------- Prims Algorithm ----------------------------------------------------------------
  public static void primsAlgo(ArrayList<Edge> graph[], int V) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[V];
    pq.add(new Pair(0, 0));

    int mstCost = 0;

    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      if (!vis[curr.node]) {
        vis[curr.node] = true;
        mstCost += curr.dist;

        for (int i = 0; i < graph[curr.node].size(); i++) {
          Edge e = graph[curr.node].get(i);
          int u = e.src;
          int v = e.dest;
          if (!vis[v]) {
            pq.add(new Pair(v, e.weight));
          }
        }
      }
    }
    System.out.println("The minimum cost using Prim's Algo is " + mstCost);
  }

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
    topSort(graph, V);
    System.out.println(isCycleUndirectedGraph(graph, new boolean[V], 0, -1));
    System.out.println("Dj \n");
    dijkstra(graph, 0, V);
    System.out.println("Bellman \n");
    BellmanFord(graph, 0, V);
  }
}
