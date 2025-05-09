package String.Easy;

import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
int []count=new int[26];
for (int i=0;i<s.length();i++){
    count[s.charAt(i)-97]++;
    count[t.charAt(i)-97]--;
}
for (int a:count) if (a!=0) return false;

return true;
    }
//    public static  boolean isAnagram(String s, String t) {
//        Map<Character,Integer> map=new HashMap<>();
//        for (int i=0;i<s.length();i++) {
//            if (!map.containsKey(s.charAt(i))){
//                map.put(s.charAt(i),1);
//            }
//            else {
//                map.put(s.charAt(i), map.get(s.charAt(i))+1);
//            }
//            if (!map.containsKey(t.charAt(i))){
//                map.put(t.charAt(i),-1);
//            }
//            else {
//
//                map.put(t.charAt(i), map.get(t.charAt(i))-1);
//            }
//        }
//        for (char a:s.toCharArray()){
//            if (map.get(a)!=0) return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        String a="anagram";
        String b="nagaram";

    }
}
