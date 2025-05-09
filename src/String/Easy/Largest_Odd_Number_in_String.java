package String.Easy;

public class Largest_Odd_Number_in_String {
    public static String largestOddNumber(String num) {
        int n=num.length();

         String ans="";

         for (int i=n-1;i>=0;i--){
             char ch=num.charAt(i);
             int n1=ch-'0';
             if (n1%2==1){
                 ans=num.substring(0,i+1);
                 break;
             }
         }
         return ans;
    }

    public static void main(String[] args) {
        String a="35427";
        System.out.println(largestOddNumber(a));
        System.out.println(Integer.parseInt(String.valueOf(a.charAt(0)))+1);
    }
}
