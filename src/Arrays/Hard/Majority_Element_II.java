package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>list=new ArrayList<>();
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        int cnt1=0;
        int cnt2=0;
        for (int i=0;i< nums.length;i++){
            if (cnt1==0&&ele2!=nums[i]){
                cnt1=1;
                ele1=nums[i];
            }
            else if (cnt2==0&&nums[i]!=ele1) {
                cnt2=1;
                ele2=nums [i];
            }
            else if(ele1==nums[i]){
                cnt1++;
            }
            else if (ele2==nums[i]) {
                cnt2++;

            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for (int i=0;i<nums.length;i++){
            if (ele1==nums[i]){
                cnt1++;
            }
            if (ele2==nums[i]){
                cnt2++;
            }
        }
        if (cnt1> nums.length/3) list.add(ele1);
        if (cnt2>nums.length/3) list.add(ele2);
        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return list;
    }
}
