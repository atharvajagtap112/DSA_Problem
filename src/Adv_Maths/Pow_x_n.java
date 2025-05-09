package Adv_Maths;

public class Pow_x_n {
    public static double myPow(double x, int n) {

            double n1=Math.abs((double)n);
            double ans=1;
            while (n1>0){
                if (n1%2==1){
                    ans=ans*x;
                    n1=n1-1;
                }
                else {
                    x=x*x;
                    n1=n1/2;
                }
    }
            return n>0?ans:1/ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,-2147483648));
    }
}
