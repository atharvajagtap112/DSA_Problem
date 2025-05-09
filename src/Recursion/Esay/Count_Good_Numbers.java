package Recursion.Esay;

public class Count_Good_Numbers {
    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even=(n / 2) + (n % 2);
        long odd =n/2;



        return (int) (myPowans(5, even) *myPowans(4, odd)% MOD) ;


    }
    long Power(long x,long y){
        if (y==0)return 1;
        long ans=Power(x,y/2);
        ans=ans*ans;
        ans=ans%MOD;
        if (y%2==1){
            ans= ans*x;
            ans=ans%MOD;
        }

        return ans;
    }

    private long myPowans(long x, long n) {
        if (n==0){
            return 1 ;
        }
        if (n%2==1){
            return x*myPowans((x*x)%MOD,(n-1)/2)%MOD;
        }
        return myPowans((x*x)%MOD,n/2) %MOD;
    }

}
