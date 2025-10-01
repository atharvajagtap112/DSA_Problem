package Leetcode_DailyChanllenge;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Replace_Non_Coprime_Numbers_in_Array {

    public int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
     List<Integer> ans=new ArrayList<>();

     for (int num:nums) {
         while (!ans.isEmpty()) {
             int cur = num;
             int prev = ans.get(ans.size() - 1);

             int gcd =gcd(cur,prev);

             if (gcd == 1) {
                 break;
             }
             ans.remove(ans.size() - 1);
             int lcm = prev / gcd * cur;
             num=lcm;
         }
         ans.add(num);
     }
      return ans;
    }
}
