package Binary_Search.Medium;

public class Find_The_Smallest_Divisor_Given_a_Threshold {
    public static int smallestDivisor(int[] nums, int threshold) {

        int max=0;
        for (int i=0;i<nums.length;i++) {
            max = Math.max(max, nums[i]);

        }
        int low=1;
        int high=max;
        while (low<=high){
            int mid=low+(high-low)/2;
            int result=divResult(nums,mid);
            if (result<=threshold){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }

    private static int divResult(int[] nums, int divisor) {
     int result=0;
     for (int i=0;i< nums.length;i++) {
         result+=Math.ceil((double)nums[i] / (double)divisor);
     }
     return result;
    }

    public static void main(String[] args) {
        int []arr={44,22,33,11,1};
        System.out.println(smallestDivisor(arr,5));

    }
}
