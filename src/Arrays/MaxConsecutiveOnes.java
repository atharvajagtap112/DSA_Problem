package Arrays;

import java.util.ArrayList;

public class MaxConsecutiveOnes {


    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int count=0;
        for (int i=0;i<nums.length;i++){

            if (nums[i]==1){
                count++;
                ans=Math.max(count,ans);
            }
            else {
                count=0;
            }


        }
        return ans;

    }
    /////////////////////////////////OOOOOOOOOOOOOOORRRRRRRRRRRRRRRRRRRRRRRRRRRRRR/////////////////////////////////////
//    public int findMaxConsecutiveOnes(int[] nums) {
//        int ans=0;
//        int count=0;
//        for (int i=0;i<nums.length;i++){
//            if(nums[i]!=0){
//                count++;
//            }
//
//            if (nums[i]==0||i==nums.length-1){
//                if (ans<count){
//                    ans=count;}
//                count=0;
//            }
//
//
//        }
//        return ans;
//
//    }
//////////////////////////////////////////////////////////////OOOOORRRRRRRR////////////////////////////////////

//        public int findMaxConsecutiveOnes(int[] nums) {
//         int start=0;
//         int end=0;
//         int max=0;
//         for (int i=0;i<nums.length;i++){
//             if (nums[i]==0||i==nums.length-1){
//                 if (nums[i]==0){
//                     end=i-1;
//                 }
//                 else {
//                     end=i;
//                 }
//                 int temp=max(start,end,nums);
//                 if (max<temp){
//                     max=temp;
//                 }
//                 start=i+1;
//             }
//         }
//         return max;
//        }
//        public int max(int start,int end,int []nums){
//            int max=0;
//            for (int i=start;i<=end;i++){
//               max++;
//            }
//            return max;
//        }


    public static void main(String[] args) {
        int []arr={1,1,0,1,1,1};
        MaxConsecutiveOnes a=new MaxConsecutiveOnes();
        System.out.println(a.findMaxConsecutiveOnes(arr));

    }
}
