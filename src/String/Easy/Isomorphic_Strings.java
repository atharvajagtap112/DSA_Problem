package String.Easy;

import java.util.*;

public class Isomorphic_Strings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
             char original=s.charAt(i);
             char replacement=t.charAt(i);
             if (!map.containsKey(original)){
                 if (!map.containsValue(replacement)){
                     map.put(original,replacement);
                 }
                 else {
                     return false;
                 }
             }
             else {
                 char ogValue=map.get(original);
                 if (ogValue!=replacement){
                     return false;
                 }
             }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="paper";
        String t="title";
        System.out.println(isIsomorphic(s,t));
    }
    public boolean rotateString(String s, String goal) {
      String temp="";
      for (int i=0;i<s.length();i++){
          String ans="";
          temp+=s.charAt(i);
          if ((s.substring(i+1,s.length())+temp).equals(goal)) return true;
      }
      return false;
    }
}
