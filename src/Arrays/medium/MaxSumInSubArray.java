package Arrays.medium;

public class MaxSumInSubArray {
    public static long pairWithMaxSum(long arr[], long N)
    {
        long sum=0;
        for (int i=1;i<arr.length;i++){
          if (sum<arr[i]+arr[i-1]){
              sum=0;
              sum=arr[i]+arr[i-1];
          }
        }
return sum;
    }

    public static void main(String[] args) {
      long []arr={4, 3, 1, 5, 6};
        System.out.println(pairWithMaxSum(arr,4));
    }
}
