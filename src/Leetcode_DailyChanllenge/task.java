package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.Map;

public class task {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        String str="one person is better person and one is not one but its not two";
       String[] arr= str.split(" ");
       for(String s:arr){
           map.put(s,map.getOrDefault(s,0)+1);
       }

       for (Map.Entry<String,Integer> pair:map.entrySet()){
           System.out.println(pair.getKey()+" "+pair.getValue());
       }
    }
}
