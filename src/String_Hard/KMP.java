package String_Hard;

public class KMP {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
       int[] lps=new int[m];
       findLPS(lps,needle);

       int first=0;
       int second=0;
       while (first<n){
           if (haystack.charAt(first)==needle.charAt(second)){
               first++;
               second++;
               if (second==m)return first-second;
           }
           else {
               if (second==0) first++;
               else second=lps[second-1];
           }
       }
       return -1;
    }

    private void findLPS(int[] lps, String needle) {
        int n=needle.length();
        int prefx=0;
        int sufx=1;
        while (sufx<n){
            if (needle.charAt(prefx)==needle.charAt(sufx)){
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

    }
}
