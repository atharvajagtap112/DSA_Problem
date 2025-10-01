package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.Map;

public class Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative=false;
        if (numerator<0&&denominator>0) isNegative=true;
        else if(numerator>0&&denominator<0) isNegative=true;

     long a=(long) numerator;
     long b=(long) denominator;
     String  ans="";
     if (a==0) return "0";

     long temp=b;
     while (temp%2==0){
         temp=temp/2;
     }

     while (temp%5==0){
         temp=temp/5;
     }

     if (temp==1){
         if (a%b==0){
           if (!isNegative)return Long.toString(a/b);
           else return '-'+Long.toString(a/b);
         }
         else {
             long r=a%b;
             long q=a/b;
             ans+=q;
             ans+='.';
             while (r!=0){
                 r=r*10;
                 q=r/b;
                 r=r&b;
                 ans+=q;
             }
         }
     }
     else {
         long r=a%b;
         long q=a/b;
         ans+=q;
         ans+='.';
         Map<Long,Long> map=new HashMap<>();
         long len=0;
         String dump="";
         while (!map.containsKey(r)){

             map.put(r,len);
             len++;
             r=r*10;
             q=r/b;
             r=r%b;
            dump+=q;
         }
         for (int i=0;i<map.get(r);i++){
             ans+=dump.charAt(i);
         }
         ans+='(';
         for (long i=map.get(r);i<dump.length();i++){
             ans+=dump.charAt((int)i);
         }
         ans+=')';
     }
     if (!isNegative) return ans;
     return '-'+ans;
    }
}
