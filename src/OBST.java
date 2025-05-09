import java.util.Arrays;

public class OBST {
  public static int[][] optCost(int [] key,int [] freq,int n){
        int [][] cost=new int[n+1][n+1];
        for (int i=0;i<=n;i++){
            cost[i][i]=0;
        }
        for (int i=0;i<n;i++){
            cost[i][i+1]=freq[i];
        }

        for (int l=2;l<=n;l++){
            for (int i=0;i<n-l+1;i++){
                int j=i+l;
                cost[i][j]=Integer.MAX_VALUE;
                for (int k=i+1;k<=j;k++){
                    int c=cost[i][k-1]+cost[k][j]+w(i,j,freq);
                    cost[i][j]=Math.min(c,cost[i][j]);
                }
            }
        }
        return cost;
    }

    private static int w(int i, int j, int[] freq) {
        int sum=0;
        for (int w=i;w<j;w++){

            sum+=freq[w];}

        return sum;
    }

    public static void main(String[] args) {
       for ( int [] a:optCost(new int[]{10,20,30,40},new int[]{4,2,6,3},4)){
           System.out.println(Arrays.toString(a));
       }
    }
}
