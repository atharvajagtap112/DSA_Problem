package sliding_window_and_two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
     int l=0; int minLength=Integer.MAX_VALUE; int sIndex=0;
     int cnt=0;

     int m=t.length(); int n=s.length();
        Map<Character, Integer> map=new HashMap<>();
        for (int i=0;i<t.length() ;i++ ){
            map.put(t.charAt(i) ,map.getOrDefault(t.charAt(i) , 0) +1);
        }

        for(int r=0;r<s.length();r++){
            if (map.getOrDefault(s.charAt(r) ,0)>0) cnt++;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);

            while (cnt==m){
                if (r-l+1<minLength) {
                    minLength=r-l+1;
                    sIndex=l;
                }
                map.put(s.charAt(l), map.get(s.charAt(l)) -1);
                if (map.get(s.charAt(l))>0) cnt--;
                l++;
            }
        }
        return minLength>n?"": s.substring(sIndex, sIndex+minLength);
    }
}
