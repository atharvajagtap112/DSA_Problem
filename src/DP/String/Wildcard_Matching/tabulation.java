package DP.String.Wildcard_Matching;

public class tabulation {

    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[]prev=new boolean[m+1];

        prev[0]=true;

        for (int j=1;j<=m;j++){
            boolean flag=true;
            for (int jj=1;jj<=j;jj++){
                if (p.charAt(jj-1)!='*')
                {
                    flag= false;
                    break;
                }
            }
            prev[j]= flag;
        }


        for (int i=1;i<=n;i++){
            boolean [] cur=new boolean[m+1];
            for (int j=1;j<=m;j++){

                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?' ) {
                    cur[j]=prev[j-1];
                }
                else if (p.charAt(j-1)=='*'){
                    cur[j]= cur[j-1]||prev[j];
                }

                else cur[j]= false;

            }
            prev=cur;
        }


        return prev[m];
    }
}
