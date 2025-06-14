package Binary_Search.Easy;

public class Search_in_Rotated_Sorted_Array_II {
    public static boolean search(int[] nums, int target) {

      int low=0;
      int high=nums.length-1;
      while (low<=high){
          int mid=(low+high) /2;
          if (nums[mid]==target) return true;

          if (nums[low]<=nums[mid]){

              if (nums[low]<=target&&target<=nums[mid]){
                  high=mid-1;
              }
              else {
                  low+=1;
              }
          }
          else {
              if (nums[mid]<=target&&target<=nums[high]){
                  low=mid+1;
              }
              else {
                 high=mid-1;
              }
          }
          }
      return false;
      }




    public static void main(String[] args) {
        int []arr={2,5,6,0,0,1,2};
        System.out.println(search(arr,6));
    }
}
