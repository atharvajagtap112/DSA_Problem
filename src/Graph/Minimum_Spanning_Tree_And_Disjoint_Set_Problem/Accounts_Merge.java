package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounts_Merge {
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
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
            Map<String,Integer> map=new HashMap<>();
            for (int i=0;i<n;i++){
                for (int j=1;j<accounts.get(i).size();j++){
                    String mail=accounts.get(i).get(j);
                    if (map.containsKey(mail)){
                        ds.unionByRank(map.get(mail),i);
                        continue;
                    }
                    map.put(mail,i);
                }
            }
            ArrayList<String>[] mergeMails=new ArrayList[n];
            for (Map.Entry<String,Integer> entry:map.entrySet()){
                if(mergeMails[ds.findParent(entry.getValue())].isEmpty()) mergeMails[ds.findParent(entry.getValue())]=new ArrayList<String>();
                mergeMails[ds.findParent(entry.getValue())].add(entry.getKey());
            }

            List<List<String>> result=new ArrayList<>();
            for (int i=0;i<mergeMails.length;i++){
                if(mergeMails[i].isEmpty()) continue;
                String name=accounts.get(i).get(0);
                ArrayList<String> list=new ArrayList<>();
                list.add(name);
                for (String mail:mergeMails[i]){
                    list.add(mail);
                }

                result.add(list);


            }
            return result;
    }
}
