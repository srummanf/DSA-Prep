/** There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]. */


import java.util.*;

class Solution {

    public int[] KahnAlgo(int[][] graph, int N) {

        // 1. Find the Indegree
        int[] indegree = new int[N];

        for (int[] edge : graph) {
            indegree[edge[0]]++;
        }

        // 2. Build Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            adj.get(edge[1]).add(edge[0]);
        }

        // 3. Define Queue and TopoSort Array
        Queue<Integer> q = new LinkedList<>();
        int[] topoSort = new int[N];

        // 4. Add nodes with Indegree 0 to Queue
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int idx = 0;

        // 5. Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            topoSort[idx++] = node;

            // 6. Process all neighbours
            for (Integer neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        // 7. Cycle Detection
        if (idx == N) {
            return topoSort;
        }

        return new int[]{};
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return KahnAlgo(prerequisites, numCourses);
    }
}

class G_24_CourseSchedulerII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = solution.findOrder(numCourses, prerequisites);

        if (order.length == 0) {
            System.out.println("No valid order exists (cycle detected).");
        } else {
            System.out.println("Valid order of courses:");
            for (int course : order) {
                System.out.print(course + " ");
            }
        }
    }
}