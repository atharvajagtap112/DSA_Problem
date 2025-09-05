package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Longest_String_Chain {

    public int longestStrChain(String[] words) {
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        int max=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){

                if (compare(words[i],words[j])&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }

            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public boolean compare(String s1,String s2){
        if (s1.length()!=s2.length()+1) return false;

        int first=0;
        int second=0;


        while (first<s1.length()){
            if (second<s2.length()&&s2.charAt(second)==s1.charAt(first)){
                first++;
                second++;
            }
            else first++;
        }

        return first==s1.length()&&second==s2.length();
    }

}
