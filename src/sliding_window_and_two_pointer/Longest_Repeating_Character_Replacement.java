package sliding_window_and_two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement {
    public static int characterReplacement(String s, int k) {
        int l=0; int maxLength=0;
        int maxFreq=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int r=0;r<s.length();r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(r)));
            if (r-l+1-maxFreq>k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            if (r-l+1-maxFreq<=k){
                maxLength=Math.max(maxLength,r-l+1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB",2));
    }
}
