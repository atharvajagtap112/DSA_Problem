package sliding_window_and_two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Fruit_Into_Baskets {
    public static int totalFruits(Integer[] arr) {
        int l=0;
        Map<Integer,Integer> map=new HashMap<>();
        int maxLength=0;
        for (int r=0;r< arr.length;r++){
            map.put(arr[r],map.getOrDefault(arr[r],0 )+1);
            if (map.size()>2){
                map.put(arr[l],map.get(arr[l])-1 );
                if (map.get(arr[l])==0) map.remove(arr[l]);
                l++;
            }
            if (map.size()<=2){
                maxLength=Math.max(maxLength,r-l+1);
            }


        }
        return maxLength;
    }
}
