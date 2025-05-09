package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

import java.util.HashMap;
import java.util.Map;

public class Most_Stones_Removed_with_Same_Row_or_Column {
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
    }
        public int removeStones(int[][] stones)  {
          int maxRow=0;
          int maxCol=0;
          for (int [] stone:stones){
              maxRow=Math.max(maxRow,stone[0]);
              maxCol=Math.max(maxCol,stone[1]);
          }

            DisjointSet DS=new DisjointSet(maxRow+maxCol+1);
            Map<Integer,Integer> map=new HashMap<>();

            for (int [] stone:stones){
                int u=stone[0];
                int v=stone[1]+maxRow+1;

                DS.unionByRank(u,v);
                map.put(u,1);
                map.put(v,1);
            }

            int cnt=0;
            for (Map.Entry<Integer,Integer> entry:map.entrySet())
                if(DS.findParent(entry.getKey())== entry.getKey()) cnt++;

            return stones.length-cnt;


    }
}
