package sliding_window_and_two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Number_of_Substrings_Containing_All_Three_Characters {
//    public int numberOfSubstrings(String s) {
//        return getNumbersOfOccurrence(s,3) -getNumbersOfOccurrence(s,2);
//    }
//
//    private int getNumbersOfOccurrence(String s, int k) {
//        Map<Character,Integer> map=new HashMap<>();
//        int l=0; int maxLength=0;
//        for (int r=0;r<s.length();r++){
//            map.put(s.charAt(r), map.getOrDefault(s.charAt(r) , 0)+1);
//            while (map.size()>k){
//                map.put(s.charAt(l), map.get(s.charAt(l))-1);
//                 if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
//                l++;
//            }
//            if (map.size()<=k) maxLength+=r-l+1;
//        }
//        return maxLength;
//    }

    public int numberOfSubstrings(String s) {
     int [] lastSeen={-1,-1,-1}; int cnt=0;
        for (int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a']=i;
            if (lastSeen[0]!=-1&& lastSeen[1]!=-1 && lastSeen[2]!=-1){
                int minBoth=Math.min(lastSeen[0],lastSeen[1]);
                cnt+=Math.min(minBoth, lastSeen[2])+1;
            }


        }
        return cnt;
   }
}
