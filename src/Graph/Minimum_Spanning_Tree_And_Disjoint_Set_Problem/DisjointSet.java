package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

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

    public void unionBySize(int u,int v){
        int ulp_u=findParent(u);
        int ulp_v=findParent(v);
        if (ulp_v==ulp_u) return;

        if (size[ulp_u]>size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u]+=size[ulp_v];

        }
      else {
            parent[ulp_u] = ulp_v;
            size[ulp_v]+=size[ulp_u];
        }

    }


    public static void main(String[] args) {
        DisjointSet ds=new DisjointSet(7);

        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        if(ds.findParent(5)==ds.findParent(7)) {
            System.out.println("TRUE");
        }
        else {
            System.out.println("FALSE");
        }
       // ds.unionByRank(3,7);

    }
}
