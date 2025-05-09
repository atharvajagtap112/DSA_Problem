package sliding_window_and_two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int count=0;
        int i=0;
        Map<Character,Integer> map=new HashMap<>();
        int j=0;
        while (j<s.length()){
            if (map.containsKey(s.charAt(j))){

                i=Math.max(map.get(s.charAt(j))+1,i);

            } count=Math.max(count,j-i+1);
            map.put(s.charAt(j),j);

            j++;
        }

        return count==0?s.length():count;
    }

    public static int longestOnes(int[] nums, int k) {
     int maxCount=0;
     int l=0;

     for (int r=0;r< nums.length;r++){

         if (nums[r]==0) {
             while (k<=0){

                 if(nums[l]==0){
                     k++;

                 }
                 l++;
             }
             k--;
         }
         maxCount=Math.max(maxCount, r-l+1);
     }
     return maxCount;
    }


    public int numSubarraysWithSum( int[]nums, int goal) {
  return helper(nums,goal)-helper(nums,goal-1);
    }
    public int helper( int[]nums, int goal){
        if(goal<0) return 0;
        int l=0;
        int maxCount=0;
        int maxlength=0;
        for (int r=0;r<nums.length;r++){
            maxCount+=nums[r];
            if (maxCount>goal){
                maxCount-=nums[r];
                l++;
            }
            maxlength+=r-l+1;
        }
        return maxlength;
      }
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
}
