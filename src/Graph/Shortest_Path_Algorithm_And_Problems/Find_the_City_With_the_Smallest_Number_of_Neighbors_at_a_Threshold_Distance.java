package Graph.Shortest_Path_Algorithm_And_Problems;

public class Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {


        int [][] dist=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dist[i][j]=(int)1e9;
            }
        }

        for (int i=0;i<n;i++){
            dist[i][i]=0;
        }

        for (int i=0;i<n;i++){
            for (int [] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int wgt=edge[2];

                dist[u][v]=wgt;
                dist[v][u]=wgt;
            }
        }

        for (int via=0;via<n;via++){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if(dist[i][via]!=(int)1e8&&dist[via][j]!=(int)1e8&& dist[i][j]>dist[i][via]+dist[via][j]){
                        dist[i][j]=dist[i][via]+dist[via][j];
                    }
                }
            }
        }
        int minCity=Integer.MAX_VALUE;
        int greatestNum=-1;
        int [] numOfCity=new int[n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(dist[j][i]!=(int)1e9) {
                    numOfCity[i]++;
                }
            }
            if(minCity>numOfCity[i]){
                minCity=numOfCity[i];
                greatestNum=i;
            }
        }
        return greatestNum;
    }
}
