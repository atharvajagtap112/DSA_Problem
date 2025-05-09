package Binary_Search.Easy;

public class Search_in_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {

 return BinarySearch(nums,target,0, nums.length-1);
    }
    public static int BinarySearch(int[] nums, int target,int start,int end) {
         int low=start;
         int high=end;

        while (low<=high){
            int mid=low+(high-low)/2;
            if (target==nums[mid]){
                return mid;
            }

            if (nums[low]<=nums[mid]){
                if (nums[low]<=target&&target<=nums[mid]){
                    high=mid-1;
                }
                else {
                    low = mid + 1;
                }}
            else {

                if (nums[mid]<=target&&target<=nums[high]){
                    low=mid+1;
                }
                else {
                    high=mid-1;
                }}

        }
        return -1;
    }

    public static void main(String[] args) {
        int []arr={0,1,2,4,5,6,7};
        System.out.println(search(arr,5));
    }
}
