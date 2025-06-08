package Graph.Other_Algo;

import java.util.*;
import java.util.stream.Collectors;

public class Articulation_Point_I {
    // Function to return Breadth First Traversal of given graph.
    int timer = 1;

    private void dfs(int node, int parent, int[] visi, int[] tin, int[] low, Set<Integer> result, ArrayList<ArrayList<Integer>> adj) {
        visi[node] = 1;
        low[node] = tin[node] = timer;
        timer++;

        int child = 0;
        for (int ti : adj.get(node)) {
            if (ti == parent) continue;

            if (visi[ti] == 0) {
                child++;
                dfs(ti, node, visi, tin, low, result, adj);
                if (parent != -1) {
                    if (low[ti] >= tin[node]) {
                        result.add(node);
                    }
                    low[node] = Math.min(low[node], low[ti]);
                }
            } else {
                low[node] = Math.min(low[node], tin[ti]);
            }
        }

        if (child > 1 && parent == -1) {
            result.add(node);
        }
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] tin = new int[V];
        int[] low = new int[V];
        Set<Integer> result = new HashSet<>();
        int[] visi = new int[V];
        for (int i = 0; i < V; i++) {
            if (visi[i] == 0) {
                dfs(i, -1, visi, tin, low, result, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(result);
        if (ans.size() == 0) return new ArrayList<>(Arrays.asList(-1));

        Collections.sort(ans);
        return ans;
    }


    public static void main(String[] args) {
     
    }
}