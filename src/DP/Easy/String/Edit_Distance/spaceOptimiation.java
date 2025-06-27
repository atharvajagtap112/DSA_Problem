package DP.Easy.String.Edit_Distance;

public class spaceOptimiation {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int []prev=new int[m+1];

        for (int j=0;j<=m;j++){
           prev[j]=j;
        }


        for (int i=1;i<=n;i++){

            int cur=i;
            for (int j=1;j<=m;j++){

                if (word1.charAt(i-1)==word2.charAt(j-1)){
                     prev[j]=prev[j-1];

                }
                else{
                    int insert=1+cur;
                    int delete=1+prev[j];
                    int replace=1+prev[j-1];
                    prev[j]=Math.min(insert,Math.min(delete,replace));

                }
                cur=prev[j];

            }

        }


        return prev[m];
    }
}
