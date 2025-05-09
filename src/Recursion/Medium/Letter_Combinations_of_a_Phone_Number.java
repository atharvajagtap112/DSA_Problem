package Recursion.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) return new ArrayList<>();



        ArrayList<String> ans=new ArrayList<>();
        String[]  mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

           letterCombiHelper(0,digits,ans,mapping,"");
return ans;
    }

    private void letterCombiHelper(int index, String digits, List<String> ans, String[] output,String s) {
        if (index==digits.length()){
            ans.add(s);
            return;
        }
        String letters=output[digits.charAt(index)-'0'];
        for (int i=0;i<letters.length();i++){
            String temp=s;
            letterCombiHelper(index+1,digits,ans,output,s+letters.charAt(i));
            s=temp;
        }
    }

//    public List<String> letterCombinations(String digits) {
//        if(digits.isEmpty()) return new ArrayList<>();
//        List<String> ans=new ArrayList<>();
//
//        Map<Integer,String > map=new HashMap<>();
//        String a="";
//
//        map.put(2,"abc");
//        map.put(3,"def");
//        map.put(4,"ghi");
//        map.put(5,"jkl");
//        map.put(6,"mno");
//        map.put(7,"pqrs");
//        map.put(8,"tuv");
//        map.put(9,"wxyz");
//        letterCombiHelper(0,digits,ans,map,"");
//        return ans;
//    }
//
//    private void letterCombiHelper(int index, String digits, List<String> ans, Map<Integer,String> map,String s) {
//        if (index==digits.length()){
//            ans.add(s);
//            return;
//        }
//        String letters=map.get(digits.charAt(index)-'0');
//        for (int i=0;i<letters.length();i++){
//            String temp=s;
//            letterCombiHelper(index+1,digits,ans,map,s+letters.charAt(i));
//            s=temp;
//        }
//    }

}
