import java.util.*;
class G_17_Bipartite_BFS{
    boolean bfs(int node, int color[], ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        // Initial Node Color = 0
        color[node] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int ngh: adj.get(curr)){
                if(color[ngh] == -1){
                    color[ngh] = 1 - color[curr];
                    q.add(ngh);
                }
                else if(color[ngh] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(bfs(i, color, adj) == false) return false;
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

        G_17_Bipartite_BFS obj = new G_17_Bipartite_BFS();
        boolean ans = obj.isBipartite(4, adj);
        if (ans) System.out.println("1"); else System.out.println("0");
    }
}