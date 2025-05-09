package Binary_Search.Medium;

public class Split_Array_Largest_Sum {
    public static int splitArray(int[] nums,int k){
      int max=-1;
      int sum=0;
      for (int i=0;i<nums.length;i++){
          max=Math.max(max,nums[i]);
          sum+=nums[i];

      }
      int low=max;
      int high=sum;
      while (low<=high){
          int mid =(low+high)/2;
          if (maxK(nums,mid)<=k){
              high=mid-1;
          }
          else low=mid+1;
      }
      return low;
    }

    private static int maxK(int[] nums, int maxSum) {
        int crntK=1;
        int crntSum=0;
        for(int i=0;i<nums.length;i++){
            if (crntSum+nums[i]<=maxSum){
                crntSum+=nums[i];

            }
            else {
                crntSum=nums[i];
                crntK++;
            }
        }
        return crntK;
    }

    public static void main(String[] args) {
        int []arr={7,2,5,10,8};
        System.out.println(splitArray(arr,2));
    }
}
