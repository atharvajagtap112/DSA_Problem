package Bit_Manipulation;

public class Divide_Two_Integers {
    public static int divide(int dividend, int divisor) {

         if (dividend==divisor) return 1;
         boolean sign=true;
         if (dividend>=0&&divisor<0) sign=false;
         else if (dividend<=0&&divisor>0) sign=false;
          long n=Math.abs(dividend);
          long d=Math.abs(divisor);

         long q=0;
         while (n>=d){
             int cnt=0;
             while (n>=(d<<(cnt+1))){
                 cnt++;

             }
             n-= (d<<cnt);
             q+=1<<cnt;

         }
         if (q==(1<<31)&&sign) return Integer.MAX_VALUE;
         if (q==(1<<31)&&!sign) return Integer.MIN_VALUE;

         return (int) (sign?q:-q);
    }

    public static void main(String[] args) {
        System.out.println(divide(22,3));
    }
}
