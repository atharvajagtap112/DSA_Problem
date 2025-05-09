package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

      Arrays.sort(nums);
    List<List<Integer>> ans=new ArrayList<>();

       for (int a=0;a<nums.length;a++){
           if (a>0&&nums[a]==nums[a-1]) continue;
        for (int i=a+1;i<nums.length-1;i++){
        if (i!=a+1&&nums[i]==nums[i-1]) continue;
        int j=i+1;
        int k= nums.length-1;
        while (j<k){
            long sum=nums[i]+nums[j]+nums[k]+nums[a];
            if (sum<target){
                j++;
            }
            else if (sum>target){
                k--;
            }
            else {
                List<Integer>temp= Arrays.asList(nums[i], nums[j], nums[k],nums[a]);

                ans.add(temp);
                j++;
                k--;
                while (j<k&&nums[j]==nums[j-1]) j++;
                while (j<k&&nums[k]==nums[k+1]) k--;
            }
        }
    }}
        return ans;}


    public static void main(String[] args) {
        int []arr={1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(arr,-294967296));
    }}