package DP.Easy.String.Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public class problem {


    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        int[]prev=new int[m+1];



        for (int j=0;j<=m;j++) prev[j]=0;

        for (int i=1;i<=n;i++){
            int[]cur=new int[m+1];
            for (int j=1;j<=m;j++){

                if (text1.charAt(i-1)==text2.charAt(j-1))
                    cur[j]= 1+prev[j-1];

                else cur[j]= Math.max(prev[j], cur[j-1]);
            }
            prev=cur;
        }



        return prev[m];


    }



    public int minInsertions(String s) {
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        return s.length()- longestCommonSubsequence(s,s2.toString());
    }
}
