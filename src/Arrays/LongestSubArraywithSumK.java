package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraywithSumK {
    public static int lenOfLongSubarr (int A[], int N, int K) {
         Map<Integer,Integer> preSumMap=new HashMap<>();
         int sum=0;
         int maxlength=0;
         for (int i=0;i<A.length;i++){
             sum+=A[i];
             int rem=sum-K;
             if (preSumMap.containsKey(rem)){
                 int lengh=i-preSumMap.get(rem);
                 maxlength=Math.max(maxlength,lengh);
             }
             if (!preSumMap.containsKey(sum)){
                 preSumMap.put(sum,i);
             }
         }
return maxlength;
    }
    public static void main(String[] args) {
        int []A={-14,10,-15,17,4,18,3,-18,-7,-4,-8,8,-8};
        System.out.println(lenOfLongSubarr(A,A.length,12));
    }
}
