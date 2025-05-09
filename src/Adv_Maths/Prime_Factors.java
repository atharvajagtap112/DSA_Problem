package Adv_Maths;

import java.util.ArrayList;
import java.util.List;

public class Prime_Factors {
    public int[] AllPrimeFactors(int N)
    {
        List<Integer> ans=new ArrayList<>();
        for (int i=2;i<Math.sqrt(N);i++){
            if (N%i==0) {
                ans.add(i);
            }
            while (N%i==0){
                N=N/i;
            }
        }
        if (N!=1) ans.add(N);
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
