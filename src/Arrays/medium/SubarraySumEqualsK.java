package Arrays.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int presum=0;
        for (int i=0;i<nums.length;i++){
            presum+=nums[i];



            int rem=presum-k;

                count=count+ map.getOrDefault(rem,0);



            map.put(presum,map.getOrDefault(presum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int []arr={1,2,3};
        System.out.println(subarraySum(arr,3));
    }
}
