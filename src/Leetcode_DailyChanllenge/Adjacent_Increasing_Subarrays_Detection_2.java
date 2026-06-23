package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.List;

public class Adjacent_Increasing_Subarrays_Detection_2 {
    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int[] countInc=new int[n];
        int cnt=1;
        countInc[0]=1;
        for (int i=1;i<n;i++){
            if(nums.get(i-1)>=nums.get(i)){
                cnt=0;
            }
            countInc[i]=++cnt;
        }
        int max=Integer.MIN_VALUE;
        for (int i=n-1;i>=0;i--){

            int k=countInc[i];
            if(i-k<0)continue;
            int val=countInc[i-k];
            if(k<=val) max= Math.max(max,k);
            else if(k%2==0&& i-(k/2)>=0&& k%(countInc[i-(k/2)] )==0){
                max=  Math.max(countInc[i-(k/2)],max);
            }


        }
        return max;

    }

    public static void main(String[] args) {

        System.out.println(maxIncreasingSubarrays(Arrays.asList(new Integer[]{-15,19})));
    }
}
