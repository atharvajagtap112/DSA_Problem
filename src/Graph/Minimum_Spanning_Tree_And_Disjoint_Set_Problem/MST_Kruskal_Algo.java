package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

import java.util.ArrayList;
import java.util.List;

public class MST_Kruskal_Algo {

    public class DisjointSet {

        int [] rank;
        int [] parent;
        int [] size;

        public DisjointSet(int n){

            this.rank=new int[n+1];
            this.parent=new int[n+1];
            this.size=new int[n+1];
            for (int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int findParent(int node){
            if(node==parent[node]) return node;
            return parent[node]=findParent(parent[node]);
        }

        public void unionByRank(int u,int v){
            int ulp_u=findParent(u);
            int ulp_v=findParent(v);
            if (ulp_v==ulp_u) return;

            if (rank[ulp_u]>rank[ulp_v]){
                parent[v]=ulp_u;

            }
            else if (rank[ulp_v]>rank[ulp_u]){
                parent[u]=ulp_v;

            }else {
                parent[v]=ulp_u;
                rank[ulp_u]++;
            }

        }
    class Edge implements Comparable<Edge>{
         int wgt;
         int src;
         int des;

        public Edge(int wgt, int src, int des) {
            this.wgt = wgt;
            this.src = src;
            this.des = des;
        }

        @Override
        public int compareTo(Edge other) {
            if(this.wgt>other.wgt) return 1;
            if(this.wgt<other.wgt) return -1;
            return 0;
        }
    }
    int spanningTree(int V, int E, List<List<int[]>> adj) {
        ArrayList<Edge> adjEdge=new ArrayList<>();
        for (List<int[]> list:adj){
            for (int [] edge:list){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                adjEdge.add(new Edge(w,u,v));
                //as we are using DJ Set so no need to add other edge v --- u
            }
        }

        int TotalWgt=0;
      DisjointSet djSet=new DisjointSet(V);
        for (Edge edge:adjEdge){
            int wgt=edge.wgt;
            int src=edge.src;
            int des=edge.des;


            if (djSet.findParent(src)!=djSet.findParent(des)){
             TotalWgt+=wgt;

             djSet.unionByRank(src,des);
        }
        }
             return TotalWgt;
    }
}}
