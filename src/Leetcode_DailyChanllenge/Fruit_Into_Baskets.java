package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.Map;

public class Fruit_Into_Baskets {
    public static int totalFruit(int[] fruits) {
        int n=fruits.length;
        Map<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int i=0;
        for(int j=0;j<n;j++){
            int f=fruits[j];
            if(!map.containsKey(f)){
                while(i<n&&map.size()>=2){
                    int val=map.get(fruits[i]);
                    val--;
                    if(val==0){
                        map.remove(fruits[i]);
                    }else{
                        map.put(fruits[i],val);
                    }
                    i++;

                } }
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            max=Math.max(max,j-i+1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
    }
}
