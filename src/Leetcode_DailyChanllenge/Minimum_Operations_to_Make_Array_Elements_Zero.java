package Leetcode_DailyChanllenge;

public class Minimum_Operations_to_Make_Array_Elements_Zero {
    public long minOperations(int[][] queries) {

         Long ans= 0L;
        for (int[] query:queries){
            int start=query[0];
            int end=query[1];

            int opration=0;

            long prev=1;
            long curr=1;
            for (int cost=1;cost<=17;cost++){
                 if(end>prev) break;
                 curr= curr*4L;

                 long l=Math.max(start,prev);
                 long r=Math.min(end,curr-1);

                 if (r>=l){
                     opration+=(r-l+1)*cost;
                 }
            }
            ans+=(opration+1)/2;
        }
        return ans;
    }
}
