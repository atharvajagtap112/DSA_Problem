package DP.Easy.String.Distinct_Subsequences;

public class recurr {
    public int fun(int i,int j,String s,String t){
        if (j<0) return 1;
        if (i<0) return 0;

        if (s.charAt(i)==t.charAt(j)){
            return fun(i-1,j-1,s,t)+fun(i-1,j,s,t);
        }
        else return fun(i-1,j,s,t);
    }
    public int numDistinct(String s, String t) {
      int n=s.length();
      int m=t.length();
            return fun(n-1,m-1,s,t);
    }


}
