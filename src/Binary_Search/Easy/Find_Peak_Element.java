package Binary_Search.Easy;

public class Find_Peak_Element {
    public static int findPeakElement(int[] nums) {

          if (nums.length==1) return 0;
          if (nums[0]>nums[1]) return 0;
          if (nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;

        int low=1;
        int high=nums.length-2;


        while (low<=high){
          int mid=low+((high)-low)/2;
          if (nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]) return mid;

          if (nums[mid]>nums[mid+1]) {
              low=mid+1;
          }

          else {
              high=mid-1;
          }


             }

         return -1;
    }

    public static void main(String[] args) {
        int []arr={};
        System.out.println(findPeakElement(arr));
        System.out.println((long)arr.length);
    }
}
