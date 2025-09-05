package DP.String.Edit_Distance;

public class recurr {
    public int fun(int i,int j,String s,String t){
        if (j<0){
            return i+1;
        }
        if (i<0){
            return j+1;
        }

        if (s.charAt(i)==t.charAt(j)){
            return fun(i-1,j-1,s,t);
        }
        int insert=1+fun(i,j-1,s,t);
        int delete=1+fun(i-1,j,s,t);
        int replace=1+fun(i-1,j-1,s,t);
        return Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
      int n=word1.length();
      int m=word2.length();

      return fun(n-1,m-1,word1,word2);
    }
}
