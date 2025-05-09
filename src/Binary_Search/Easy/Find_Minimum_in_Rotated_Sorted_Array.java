package Binary_Search.Easy;

public class Find_Minimum_in_Rotated_Sorted_Array {
    public static int findMin(int[] nums) {
        int min=nums[0];
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (nums[low]<=nums[mid]&&nums[mid]<=nums[high]){
                return nums[low];
            }
            else if (nums[low]<=nums[mid]){
                min=Math.min(min,nums[low]);
                low=mid+1;
            }
            else {
                min=Math.min(min,nums[mid]);
                high=mid-1;
            }
        }
        return min;

    }
//    public static int findMin(int[] nums) {
//
//        return minRotate(nums,0,nums.length-1 );
//    }
//
//    private static int minRotate(int[] nums, int start, int end) {
//        int ans=nums[start];
//        if (start>=end){
//            return Math.min(nums[start],ans);
//        }
//        int mid=start+(end-start)/2;
//        ans=Math.min(ans,nums[mid]);
//        ans=Math.min(ans,minRotate(nums,start,mid-1));
//        ans=Math.min(ans,minRotate(nums,mid+1,end));
//        return ans;
//    }


    public static void main(String[] args) {
        int []arr={3,4,5,1,2};
        System.out.println(findMin(arr));
    }
}
