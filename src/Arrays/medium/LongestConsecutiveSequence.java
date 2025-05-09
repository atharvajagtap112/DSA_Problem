package Arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
           int longest=1;
           int count=0;
        Set<Integer> set=new HashSet<>();
        for (int a:nums){
            set.add(a);
        }
        for (Integer ele:set){
            if (!set.contains(ele-1)){
                int a=ele;
               while (set.contains(a+1)){

                   count++;
                   a++;
               }
               longest=Math.max(count+1,longest);
               count=0;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int []arr={100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }
}
