package String.Medium;

public class Count_number_of_substrings {

    private static long upto(String s, int k,int n) {
      int l=0,r = 0,cnt=0;
      long ans=0;
      int[] mp=new int[26];
      while (r<n){
          mp[s.charAt(r)-'a']++;
          if (mp[s.charAt(r)-'a']==1) cnt++;
          while (cnt>k){
              mp[s.charAt(l)-'a']--;
              if(mp[s.charAt(l)-'a']==0){
                  cnt--;
              }
              l++;
          }
          r++;
          ans+=r-l+1;
      }
return ans;
    }

    static long substrCount (String S, int K) {
     return upto(S,K,S.length())-upto(S,K-1,S.length());
   }


    public static void main(String[] args) {
String s="aba";
        System.out.println(substrCount(s,2));
    }
}
