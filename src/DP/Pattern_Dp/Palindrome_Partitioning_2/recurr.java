package DP.Pattern_Dp.Palindrome_Partitioning_2;

public class recurr {

    public int fun(int i,int j,String s){
        if (i>j)return -1;

        int min=(int)1e9 ;
        for (int ind=i;ind<=j;ind++){

            if(isPalindrome(i,ind,s)){
                int pt=1+fun(ind+1,j,s);
                min=Math.min(pt,min);
            }
        }
        return min;
    }

    private boolean isPalindrome(int i, int j, String s) {

        while (i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public int minCut(String s) {
return fun(0,s.length()-1,s);
    }
}
