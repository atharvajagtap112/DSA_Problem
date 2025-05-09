package Binary_Search;

public class Search_Insert_Position {
    public static int searchInsert(int[] nums, int target) {
        int start=0;
        int end= nums.length-1;
        int ans=nums.length;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (target==nums[mid]){
                return mid;
            }
            if (nums[mid]>target){
                end=mid-1;
                ans=mid;
            }
            else {

                start=mid+1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int []arr={1,3,5,6};
        System.out.println(searchInsert(arr,7));
    }
}
