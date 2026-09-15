/**
 * Alien Dictionary
 *
 * Given words sorted according to an alien language,
 * find the order of characters in the alien alphabet.
 *
 * Approach:
 * 1. Find all unique characters and assign them indices 0...k-1.
 * 2. Compare adjacent words.
 * 3. The first different character gives a directed edge.
 * 4. Calculate indegrees.
 * 5. Apply Kahn's Algorithm to get the Topological Sort.
 * 6. If all characters cannot be processed, a cycle exists.
 *
 * Time Complexity:
 * O(N * L + K + E)
 *
 * Space Complexity:
 * O(K + E)
 */

import java.util.*;

class Solution {

    /**
     * Kahn's Algorithm - Topological Sort using BFS
     *
     * Steps:
     * 1. Find Indegree of every node.
     * 2. Add nodes with Indegree 0 to Queue.
     * 3. Pop node from Queue and add it to Topological Sort.
     * 4. Decrease Indegree of all neighbours.
     * 5. If Indegree becomes 0, add neighbour to Queue.
     */
    public List<Integer> topoSort(int N, ArrayList<ArrayList<Integer>> adj) {

        // 1. Find Indegree
        int[] indegree = new int[N];

        for (int i = 0; i < N; i++) {

            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        // 2. Define Queue
        Queue<Integer> q = new LinkedList<>();

        // 3. Add nodes with Indegree 0 to Queue
        for (int i = 0; i < N; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // 4. Topological Sort
        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            topo.add(node);

            // 5. Process all neighbours
            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return topo;
    }


    /**
     * Finds the order of characters in the Alien Dictionary.
     *
     * Compare adjacent words.
     * The first different character gives us a directed edge.
     *
     * Example:
     *
     * "baa"
     * "abcd"
     *
     * b != a
     *
     * Therefore:
     *
     * b -> a
     */
    public String findOrder(String[] dict, int N, int K) {

        // 1. Build Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Build Graph
        for (int i = 0; i < N - 1; i++) {

            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());

            /*
             * Compare characters of adjacent words.
             *
             * Only the FIRST different character matters.
             */
            for (int ptr = 0; ptr < len; ptr++) {

                if (s1.charAt(ptr) != s2.charAt(ptr)) {

                    int u = s1.charAt(ptr) - 'a';
                    int v = s2.charAt(ptr) - 'a';

                    // u comes before v
                    adj.get(u).add(v);

                    // Stop after first difference
                    break;
                }
            }
        }

        // 3. Perform Topological Sort
        List<Integer> topo = topoSort(K, adj);

        // 4. Convert Integer nodes back to Characters
        StringBuilder ans = new StringBuilder();

        for (int node : topo) {
            ans.append((char) (node + 'a'));
        }

        return ans.toString();
    }
}


/**
 * Driver Code
 */
class G_26_AlienDictionary {

    public static void main(String[] args) {

        int N = 5;
        int K = 4;

        String[] dict = {
            "baa",
            "abcd",
            "abca",
            "cab",
            "cad"
        };

        Solution solution = new Solution();

        String ans = solution.findOrder(dict, N, K);

        System.out.println(ans);
    }
}