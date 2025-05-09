package Greedy.Esay;

import java.util.HashMap;
import java.util.Map;
public class Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {

       Map<Integer,Integer> map=new HashMap<>();
       for (int i=0;i<bills.length;i++) {
           int amount = bills[i];
           map.put(10, map.getOrDefault(10, 0) + 1);
           if (amount == 10) {
               if (map.getOrDefault(5, 0) > 0) {
                   map.put(5, map.get(5) - 1);
               } else return false;
           }

           if (amount == 20) {
               if (map.getOrDefault(5, 0) > 0 && map.getOrDefault(10, 0) > 0) {
                   map.put(5, map.get(5) - 1);
                   map.put(10, map.get(10) - 1);
               } else if (map.getOrDefault(5, 0) >= 3) {
                   map.put(5, map.get(5) - 3);
               } else return false;
           }
       }
       return true;
    }
}
