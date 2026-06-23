package Leetcode_DailyChanllenge;

public class Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating {

    public  static int minFlips(String s) {
        int f1=0;
        int f2=0;
        int n=s.length();
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(i%2==0){
                if(ch=='0') f1++;
                else f2++;
            }
            else{
                if(ch=='1') f1++;
                else f2++;
            }
        }
        int min=Math.min(f1,f2);

        String str=s+s;
        for(int i=n;i<str.length();i++){
            char ch=str.charAt(i);
            if((i-n)%2==0){

                if(str.charAt(i-n)=='0'){
                    f1--;
                }else f2--;
            }
            else{
                if(str.charAt(i-n)=='1'){
                    f1--;
                }else f2--;
            }

            if(i%2==0){
                if(ch=='0') f1++;
                else f2++;
            }
            else{
                if(ch=='1') f1++;
                else f2++;
            }

            min=Math.min(f1,f2);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minFlips("01001001101"));
    }
}
