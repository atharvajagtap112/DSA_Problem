package DP.Easy.String.Longest_Common_Subsequence;

public class recurr {
    public int fun1(int i,int j,String text1,String text2){
        if (i<0||j<0) return 0;

        if (text1.charAt(i)==text2.charAt(j))
            return 1+fun1(i-1,j-1,text1,text2);

        return 0+Math.max(fun1(i,j-1,text1,text2),fun1(i-1,j,text1,text2));
    }
    public int longestCommonSubsequence1(String text1, String text2) {
      int n=text1.length();
      int m=text2.length();
       return fun1(n-1,m-1,text1,text2);


    }

    // index shifting
    public int fun(int i,int j,String text1,String text2){
        if (i==0||j==0) return 0;

        if (text1.charAt(i-1)==text2.charAt(j-1))
            return 1+fun(i-1,j-1,text1,text2);

        return 0+Math.max(fun(i,j-1,text1,text2),fun(i-1,j,text1,text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        return fun(n,m,text1,text2);


    }
}
