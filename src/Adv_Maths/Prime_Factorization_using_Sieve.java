package Adv_Maths;

import java.util.ArrayList;
import java.util.List;

public class Prime_Factorization_using_Sieve {

    static int[] sieve() {
        int n=2*100000;
        int [] spf=new int[n+1];
        for (int i=1;i< spf.length;i++) spf[i]=i;

        for (int i=2;i*i<n;i++){
            if (spf[i]==i){
                for (int j=i*i;j< spf.length;j+=i){
                    if (spf[j]==j){
                         spf[j]=i;
                    }
                }
            }
        }
         return spf;
    }

    static List<Integer> findPrimeFactors(int N) {
          List<Integer> ans= new ArrayList<>();
          int []spf=sieve();
          while (N!=1){
              int n=spf[N];
              ans.add(n);
              N=N/n;

          }
          return ans;
    }

    public static void main(String[] args) {
        System.out.println(findPrimeFactors(30));
    }
}
