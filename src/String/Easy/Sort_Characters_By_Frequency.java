package String.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
         Map<Character,Integer> map=new HashMap<>();
         for (char ch:s.toCharArray()){
             map.put(ch,map.getOrDefault(ch,0)+1);
         }
        List<Character> list=new ArrayList<>(map.keySet());
         list.sort((obj1,obj2)->map.get(obj2)-map.get(obj1));
         StringBuilder answer=new StringBuilder();
         for (Character key:list){
             for (int i=0;i<map.get(key);i++){
                 answer.append(key);
             }
         }
         return answer.toString();
    }
}
