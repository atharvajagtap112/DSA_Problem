package Recursion.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break {
    public static boolean wordBreak(String s, List<String> wordDict) {

        return wordBreakHelper(0,0,s, new HashSet<>(wordDict));
    }

    private static boolean wordBreakHelper(int start,int end,String s, Set<String> set) {
        if (end==s.length()-1) {
            if (s.contains(s.substring(start,end+1))){
                return true;
            }
            return false;
        }
       if (s.contains(s.substring(start,end+1))){
          if( wordBreakHelper(end+1,end+1,s,set));
          return true;
       }
         return wordBreakHelper(start,end+1,s,set);
    }


    public static void main(String[] args) {
        String s="aaaaaaa";
        ArrayList<String> list=new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");

        wordBreak(s,list);
    }
}
