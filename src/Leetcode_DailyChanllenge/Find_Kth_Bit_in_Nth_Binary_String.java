package Leetcode_DailyChanllenge;

import java.util.Arrays;

public class Find_Kth_Bit_in_Nth_Binary_String {
    public static String reverse(char[] s){
        int i=0;
        int j=s.length-1;
        while(i<=j){
            if(i==j){
                s[i]=s[i]=='0'?'1':'0';
                i++;
                j--;
                break;
            }
            char temp=s[i]=='0'?'1':'0';
            s[i]=s[j]=='0'?'1':'0';
            s[j]=temp;
            i++;
            j--;


        }
        return new String(s);
    }
    public  static char findKthBit(int n, int k) {
        String s="0";
        for(int i=2;i<=n;i++){
            s=s+'1'+reverse(s.toCharArray());
        }
        return s.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(4,11));
    }
}
