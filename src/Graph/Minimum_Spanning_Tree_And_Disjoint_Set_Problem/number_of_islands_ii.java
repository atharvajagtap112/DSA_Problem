package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

import java.util.ArrayList;
import java.util.List;

public class number_of_islands_ii {
    class DisjointSet {

        int[] rank;
        int[] parent;
        int[] size;

        public DisjointSet(int n) {

            this.rank = new int[n + 1];
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findParent(parent[node]);
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

        public void unionBySize(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if (ulp_v == ulp_u) return;

            if (size[ulp_u] > size[ulp_v]) {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];

            } else {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }

        }
    }

    private boolean isValid(int row, int col,int n,int m) {
        return row>=0&&row<n&&col>=0&&col<m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        int[][] visi=new int[n][m];
        int cnt=0;
        List<Integer> result=new ArrayList<>();

        DisjointSet ds=new DisjointSet(n*m);

        for (int[] island:operators){
            int row=island[0];
            int col=island[1];

            if (visi[row][col]==1){
                result.add(cnt);
                continue;
            }

            cnt++;
            visi[row][col]=1;
            // row - 1, col
            // row , col + 1
            // row + 1, col
            // row, col - 1;
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int i=0;i<4;i++){
                if(isValid(dr[i], dc[i] ,n,m)){
                    int adjRow=dr[i];
                    int adjCol=dc[i];
                    int node=row*m+col;
                    int adjNode=adjRow*m+adjCol;
                    if(visi[adjRow][adjCol]==1){
                        if(ds.findParent(adjNode)!= ds.findParent(node)){
                            cnt--;
                            ds.unionByRank(adjNode,node);
                        }
                    }

                }

            }
            result.add(cnt);
        }
        return result;
    }



}
