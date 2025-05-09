package Arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Rearrange_Array_Elements_by_Sign {

    public static int[] rearrangeArray(int[] nums) {

      int even=-1;
      int odd=-1;
      int evenPntr=0;
      int oddpntr=1;
      int oddpntr33=2;
      if (nums.length>1){
          while (evenPntr<nums.length&&oddpntr< nums.length){
              if (nums[evenPntr]<0){
                  even=evenPntr;
              }
              if (nums[oddpntr]>0){
                  odd=oddpntr;
              }
              if (even!=-1&&odd!=-1){
                 int temp=nums[even];
                 nums[even]=nums[odd];
                 nums[odd]=temp;
                 odd=-1;
                 even=-1;
              }
              if (even==-1){
                  evenPntr=evenPntr+2;
              }
               if (odd==-1){
                  oddpntr33=oddpntr33+2;
                  oddpntr=oddpntr33-1;}
          }
      }
      return nums;
    }



    //Its Swaps correct but the order is disturb
//    public static int[] rearrangeArray(int[] nums) {
//      for (int i=0;i<nums.length;i++){
//          if ((i%2==0||i==0)&&nums[i]<0){
//          for (int j=i+1;j< nums.length;j++){
//              if (nums[j]>0){
//                  swap(i,j,nums);
//                  break;
//              }
//          }
//          }
//          else if(i%2!=0&&nums[i]>0){
//              for (int j=i+1;j< nums.length;j++){
//                  if (nums[j]<0){
//                      swap(i,j,nums);
//                      break;
//                  }
//          }}
//
//
//      }
//      return nums;
//    }
//
//  private static void swap(int i, int j, int[] nums) {
//        int temp=nums[i];
//        nums[i]=nums[j];
//        nums[j]=temp;
//    }

    public static void main(String[] args) {
        int []nums={-1,1};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
}
