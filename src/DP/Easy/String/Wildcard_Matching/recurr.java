package DP.Easy.String.Wildcard_Matching;

public class recurr {
    public boolean fun(int i,int j,String s,String p){
        if (i<0&&j<0)return true;
         if (j<0&&i>=0)return false;
         if (i<0&&j>=0){
             for (int jj=0;jj<=j;jj++){
                 if (p.charAt(jj)!='*') return false;
             }
             return true;
         }

         if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?' ) return fun(i-1,j-1,s,p);
         else if (p.charAt(j)=='*'){
             return fun(i,j-1,s,p) ||fun(i-1,j,s,p);
         }

         return false;
    }
    public boolean isMatch(String s, String p) {
      int n=s.length();
      int m=p.length();


      return fun(n-1,m-1,s,p);

    }
}
