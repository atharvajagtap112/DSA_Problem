package DP.Pattern_Dp.Palindrome_Partitioning_2;

public class tabulation {


    private boolean isPalindrome(int i, int j, String s) {

        while (i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];

        for (int i=n-1;i>=0;i--){

            int min=(int)1e9 ;
            for (int j=i;j<s.length();j++){

                if(isPalindrome(i,j,s)){
                    int pt=1+dp[j+1];
                    min=Math.min(pt,min);
                }
            }
             dp[i]= min;
        }

        return dp[0]-1;
    }
}
