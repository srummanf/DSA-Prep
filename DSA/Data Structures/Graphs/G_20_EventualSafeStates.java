import java.util.*; 

class G_20_EventualSafeStates{
    boolean dfs(int node, int vis[], int pathVis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1; 
        pathVis[node] = 1; 
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, vis, pathVis, adj) == true) 
                    return true; 
            }
            // if adjacent node is visited and is in the current path
            else if(pathVis[adjacentNode] == 1) return true; 
        }
        pathVis[node] = 0; 
        return false; 
    }

    public List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        Arrays.fill(vis, 0);
        Arrays.fill(pathVis, 0);
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                dfs(i, vis, pathVis, adj); 
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(pathVis[i] == 0) safeNodes.add(i); 
        }
        return safeNodes; 
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
                
        G_20_EventualSafeStates obj = new G_20_EventualSafeStates();
        List<Integer> ans = obj.eventualSafeNodes(4, adj);
        
        System.out.println("Eventual Safe Nodes: " + ans);
    }
}