package Recursion.Esay;

public class Pow_x_n {
    public double myPow(double x, int n) {
        long nn=n;
      if (n>0){
          return myPowans(x,nn);

      }
      else return 1/myPowans(x,nn*-1);
    }
    private double myPowans(double x, long n) {
        if (n==1){
            return x;
        }
        if (n%2==1){
            return x*myPowans(x,(n-1)/2);
        }
        return myPowans(x=x*x,n/2);
    }
}
