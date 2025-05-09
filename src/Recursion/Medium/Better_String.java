package Recursion.Medium;

import java.util.*;

public class Better_String {
    public static String betterString(String str1, String str2) {
       int a=count(str1);
       int b=count(str2);
       if (a>=b) return str1;
       return str2;

    }
  public  static   int count(String str){
        int n=str.length();
        int [] dp=new int[n+1];
        Map<Character,Integer> map=new HashMap<>();
        dp[0]=1;
        for (int i=1;i<=n;i++){
            dp[i]=dp[i-1]*2;
            if (map.containsKey(str.charAt(i-1))){
                dp[i]=dp[i]-dp[map.get(str.charAt(i-1))];
            }

                map.put(str.charAt(i),i+1);

        }
        return dp[n];
    }
    public static void main(String[] args) {

    }
}
