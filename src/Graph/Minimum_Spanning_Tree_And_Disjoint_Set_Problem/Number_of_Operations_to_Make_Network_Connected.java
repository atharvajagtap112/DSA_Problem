package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

public class Number_of_Operations_to_Make_Network_Connected {
  class DisjointSet {

        int[] rank;
        int[] parent;

        public DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findParent(parent[node]); // path compression
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if (ulp_u == ulp_v) return;

            if (rank[ulp_u] > rank[ulp_v]) {
                parent[ulp_v] = ulp_u;
            } else if (rank[ulp_v] > rank[ulp_u]) {
                parent[ulp_u] = ulp_v;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int totalEdges=connections.length;

        DisjointSet djSet=new DisjointSet(n);
        int curEdges=0;
        for (int [] edge:connections){
            int u=edge[0];
            int v=edge[1];
            // or else if both parent are same we can cal extra also 
            if (djSet.findParent(u)!=djSet.findParent(v)){
                curEdges++;
                djSet.unionByRank(u,v);
            }
        }

        int currNodes=curEdges+1;
        return totalEdges-curEdges>=n-currNodes?n-currNodes:-1;

    }
}
