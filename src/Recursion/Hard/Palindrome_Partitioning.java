package Recursion.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Palindrome_Partitioning {
    public static List<List<String>> partition(String s) {
       List<List<String>> ans=new ArrayList<>();
          partitionHelper(0,new ArrayList<>(),s,ans);
          return ans;
    }

    private static void partitionHelper(int index, ArrayList<String> temp, String s, List<List<String>> ans) {
        if(index==s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=index;i<s.length();i++){
              boolean isPlaindrome=palindromeCheck(s,index,i);
              if (isPlaindrome){
                  temp.add(s.substring(index,i+1));
                  partitionHelper(i+1,temp,s,ans);
                  temp.remove(temp.size()-1);
              }

        }

    }

    private static boolean palindromeCheck(String  str,int left,int right) {
        if(str.isEmpty()) return false;

        while (left<=right){
            if (str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String a="aab";
        partition(a);
    }
}
