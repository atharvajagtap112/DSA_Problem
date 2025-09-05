package String_Hard;

public class Longest_Prefix_Suffix {

    public String longestPrefix(String s) {
     int n=s.length();
     int[] lps=new int[n];

     int prefx=0;
     int sufx=1;
     while (sufx<n){
         if (s.charAt(prefx)==s.charAt(sufx)) {
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
              return s.substring(0,lps[n-1]);
    }


}
