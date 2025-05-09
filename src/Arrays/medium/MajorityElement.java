package Arrays.medium;

import java.util.Arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int ele=nums[0];
        int count=0;
        for (int i=0;i< nums.length;i++){
            if (ele==nums[i]){
                count++;
            }
            else if(count==0){
                ele=nums[i];
                count=1;
            }
            else {
                count--;
            }
        }
        //checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) cnt1++;
        }

        if (cnt1 > (nums.length / 2)) return ele;

        return -1;
    }

    public static void main(String[] args) {
        int[] a={3,3,4};
        System.out.println(majorityElement(a));
    }
}
