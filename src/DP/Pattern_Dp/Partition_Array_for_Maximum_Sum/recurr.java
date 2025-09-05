package DP.Pattern_Dp.Partition_Array_for_Maximum_Sum;

public class recurr {

    public int fun(int i,int k,int[] arr,int n){
        if (i==n)return 0;

        int largestSum=0;
        int max=(int)-1e9;
        int cnt=0;
        for (int j=i;j<Math.min(i+k,n);j++) {
            max = Math.max(max, arr[j]);
            cnt++;
            int sum = cnt * max + fun(j + 1, k, arr, n);
            largestSum = Math.max(largestSum, sum);
        }
        return largestSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        return fun(0,k,arr,n);
    }
}
