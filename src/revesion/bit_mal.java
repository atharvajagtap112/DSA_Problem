package revesion;

import java.util.ArrayList;
import java.util.List;



public class bit_mal {

    public static int divide(int dividend, int divisor) {
      if (dividend==divisor) return 1;
      boolean sign=true;
      if (dividend>=0&&divisor<0) {
          sign=false;
      }
      if (dividend<0&&divisor>=0){
          sign=false;
      }
      long n=Math.abs(dividend);
      long d=Math.abs(divisor);
      long ans=0;
      while (n>=d){
          int cnt=0;
          while (n>=(d<<cnt+1)){
              cnt++;
          }
          ans+=1<<cnt;
          n-=d<<cnt;
      }
      if (ans>Integer.MAX_VALUE&&sign){
          return Integer.MAX_VALUE;
      }
      if(ans>Integer.MIN_VALUE&&!sign)
      {
          return Integer.MIN_VALUE;
      }
      return (int)(sign? ans:-1*ans);
    }

    public static int minBitFlips(int start, int goal) {
        int cnt=0;
        while (start!=0){
            if (start==goal) return cnt;
            if((start&1)!=(goal&1)){
                cnt++;
            }
            start=start>>1;
            goal=goal>>1;
        }
        return cnt;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        for (int i=0;i<(1<< nums.length); i++){
            ArrayList<Integer> temp=new ArrayList<>();
            int cnt=0;
            while (cnt<nums.length-1){
                if ((i&1<<cnt)>0){
                    temp.add(nums[cnt]);
                    cnt++;
                }
            }
            result.add(temp);
        }
     return result;
    }


    public static int findXOR(int l, int r) {

        return helper(l-1)^helper(r);
    }

    private static int helper(int i) {
        int n=i%4;
        if (n==1) return 1;
        if (n==2) return n+1;
        if (n==3) return 0;
        return i;
    }

    public int[] twoOddNum(int Arr[], int N)
    {
        int num=0;
        for (int i=0;i<Arr.length;i++){
            num=num^Arr[i];
        }
        int b1=0;
        int b2=0;
        int rightmost=(num^num-1)&num;
        for (int i=0;i<Arr.length;i++){
             if ((Arr[i]&rightmost)!=0) b1=Arr[i];
             else b2=Arr[i];
        }
         return b1>b2? new int[]{b1,b2}: new int[] {b2,b1};
    }

    public int[] AllPrimeFactors(int N)
    {
        ArrayList<Integer> list=new ArrayList<>();
         for (int i=2;i<Math.sqrt(N);i++){
             if(N%i==0){
                 list.add(i);
                 while (N%i==0){
                     N=N/i;
                 }
             }
         }
         if (N!=1){
             list.add(N);
         }
       return list.stream().mapToInt(Integer::intValue).toArray();

    }
    public static double myPow(double x, int n) {
        if (n==0) return 1;
       double p=Math.abs((double) n);
        double ans=x;
        while (p>1){
            if(p%2==0){
                ans=ans*ans;
                p=p/2;
            }
            else {
                ans=ans*ans*x;
                p=(p-1)/2;
            }
        }
        return n<0? 1/ans:ans;
    }

}
