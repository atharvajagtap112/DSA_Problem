package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

import java.util.HashSet;
import java.util.Set;

public class Making_A_Large_Island {
    class DisjointSet {


        int[] parent;
        int[] size;

        public DisjointSet(int n) {


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
    private boolean isValid(int adjRow, int adjCol,int n) {
        return adjRow>=0&&adjRow<n&&adjCol>=0&&adjCol<n;
    }

    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        //step 1
        for (int row=0;row<n;row++){
            for (int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, 1, 0, -1};
                for (int i=0;i<4;i++){
                    int adjRow=row+dr[i];
                    int adjCol=col+dc[i];
                    if(isValid(adjRow,adjCol,n)&&grid[adjRow][adjCol]==1){
                    int node=row *n+col;
                    int adjNode=adjRow*n+adjCol;

                    ds.unionBySize(node,adjNode);
                }
                }
            }
        }

        int mx=0;
        for (int row=0;row<n;row++){
            for (int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, 1, 0, -1};
                Set<Integer> set=new HashSet<>();
                for (int i=0;i<4;i++){
                    int adjRow=row+dr[i];
                    int adjCol=col+dc[i];
                    if(isValid(adjRow,adjCol,n)&&grid[adjRow][adjCol]==1){
                        int adjNode=adjRow*n+adjCol;
                       set.add(ds.findParent(adjNode));
                    }

                    int cnt=0;
                    for (int upl:set){
                        cnt+=ds.size[upl];
                    }
                    mx=Math.max(mx,cnt+1);
                }
            }
        }

        for (int node=0;node<n*n;node++){
            mx=Math.max(mx,ds.size[ds.findParent(node)]);
        }

        return mx;
    }



}
