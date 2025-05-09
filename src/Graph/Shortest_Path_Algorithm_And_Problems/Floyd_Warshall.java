package Graph.Shortest_Path_Algorithm_And_Problems;

public class Floyd_Warshall {
    public void floydWarshall(int[][] dist) {
        int n=dist.length;
        for (int via=0;via<n;via++){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if(dist[i][via]!=(int)1e8&&dist[via][j]!=(int)1e8&& dist[i][j]>dist[i][via]+dist[via][j]){
                        dist[i][j]=dist[i][via]+dist[via][j];
                    }
                }
            }
        }

    }
}
