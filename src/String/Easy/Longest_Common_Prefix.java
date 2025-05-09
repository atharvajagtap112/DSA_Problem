package String.Easy;

public class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {

         String ans="";
        String temp="";
         for (int i=0;i<strs[0].length();i++){
             char comapre=strs[0].charAt(i);

             boolean match=true;
             for (int j=0;j<strs.length;j++){

                 if (i>=strs[j].length()||(char)(strs[j].charAt(i))!=comapre){
                     match=false;
                     break;
                 }
             }
             if (match==true){
                 temp+=comapre;
                 ans=temp;
             }else {
                break;
             }
         }
//         if (ans.length()<temp.length()) return temp;
         return ans;
    }

    public static void main(String[] args) {
        String []a={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(a));
    }
}
