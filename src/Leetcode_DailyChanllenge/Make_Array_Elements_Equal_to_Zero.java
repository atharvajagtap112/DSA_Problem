package Leetcode_DailyChanllenge;

import java.util.Arrays;

public class Make_Array_Elements_Equal_to_Zero {

    public boolean isValid(int [] nums,boolean left, int i){
        int n=nums.length;

        while(i>=0&&i<n){
            if(nums[i]==0){
                if(left) i--;
                else i++;
            }
            else {
                nums[i]--;
                if(left){
                    i++;
                    left=false;

                }
                else {
                    i--;
                    left=true;
                }
            }
        }

        for (int no:nums){
            if (no!=0) return false;
        }
        return true;
    }
    public int countValidSelections(int[] nums) {

        int n=nums.length;
        int cnt=0;
        for (int i=0;i<n;i++){
            if(nums[i]==0){
                int[] temp= Arrays.copyOf(nums,n);
                 if (isValid(temp,true,i)) cnt++;
               int[] temp1=Arrays.copyOf(nums,n);
                 if(isValid(temp1,false,i)){
                  cnt++;
                }
            }
        }
        return cnt;

    }
}
