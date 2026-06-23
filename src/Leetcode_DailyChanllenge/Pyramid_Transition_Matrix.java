package Leetcode_DailyChanllenge;

import java.util.*;
import java.util.stream.Collectors;

public class Pyramid_Transition_Matrix {

    Map<String,Boolean> map=new HashMap<>();
    boolean fun(int i, String org, Set<String> set,String temp){
        if(i==org.length()-1){
            if (temp.length()==1)return true;
            if (map.containsKey(temp)) return map.get(temp);
            boolean res=fun(0,temp,set,"");
            map.put(temp,res);
             return res;
        }

        for (char ch='A';ch<='F';ch++){
            if (set.contains(""+org.charAt(i)+org.charAt(i+1)+ch)){
                if (fun(i+1,org,set,temp+ch)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Set<String> set=new HashSet<>(allowed);

        return fun(0,bottom,set,"");

    }
}
