/** There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible. */


import java.util.*;

class Solution {

    public boolean KahnAlgo(int[][] graph, int N) {

        // 1. Find the Indegree
        int[] indegree = new int[N];

        for (int[] edge : graph) {
            indegree[edge[1]]++;
        }

        // 2. **** Build Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            adj.get(edge[0]).add(edge[1]);
        }

        // 3. Define a Queue
        Queue<Integer> q = new LinkedList<>();

        // 4. Add nodes with indegree 0 to Queue
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        // 5. Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();
            cnt++;

            // 6. Process all neighbours
            for (Integer neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        // If all nodes are processed -> No Cycle
        // Otherwise -> Cycle exists
        return cnt == N;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        return KahnAlgo(prerequisites, numCourses);
    }
}

class G_24_CourseScheduler {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        Solution solution = new Solution();
        boolean canFinish = solution.canFinish(numCourses, prerequisites);

        System.out.println("Can finish all courses: " + canFinish);
    }
}