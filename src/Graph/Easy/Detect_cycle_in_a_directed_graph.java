package Graph.Easy;

import java.util.ArrayList;

public class Detect_cycle_in_a_directed_graph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbor] == 1) {
                return true; // cycle detected
            }
        }

        pathVisited[node] = 0; // backtrack
        return false;
    }
}
