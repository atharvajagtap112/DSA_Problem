package String_Hard;

public class Shortest_Palindrome {

    public int [] kmp(String s){
        int n=s.length();
        int [] lps=new int[n];
        int prefx=0;
        int sufx=1;
        while (sufx<n){
            if (s.charAt(sufx)==s.charAt(prefx)){
                lps[sufx]=prefx+1;
                prefx++;
                sufx++;
            }
            else {
                if (prefx==0) sufx++;
                else {
                    prefx=lps[prefx-1];
                }
            }
        }
        return lps;
    }

    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public String shortestPalindrome(String s) {

        String revStr = reverse(s);
        String combined = s + "$" + revStr;
        int[] lps = kmp(combined);


        int palindromePrefixLen = lps[combined.length() - 1];


        String toAdd = revStr.substring(0, revStr.length() - palindromePrefixLen);
        return toAdd + s;
    }
}
