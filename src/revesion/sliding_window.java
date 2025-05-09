package revesion;

import java.util.HashMap;
import java.util.Map;

public class sliding_window {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int l=0;
        int maxCount=0;
        for (int r=0;r<s.length();r++){
            if (map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r))>=l){
                    l=map.get(s.charAt(r));
                    l++;
                }


            }
            maxCount=Math.max(maxCount,r-l+1);
            map.put(s.charAt(r),r);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
