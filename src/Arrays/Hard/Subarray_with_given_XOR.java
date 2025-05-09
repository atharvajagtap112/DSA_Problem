package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Subarray_with_given_XOR {
    public static int solve(ArrayList<Integer> A, int B) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int Xr=0;
        int count=0;
        for (int i=0;i<A.size();i++){
            Xr=Xr^ A.get(i);
            int x=Xr^B;
            count=count+map.getOrDefault(x,0);
            map.put(Xr, map.getOrDefault(Xr,0)+1);

        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(4);
        arr.add(2);
        arr.add(2);
        arr.add(6);
        arr.add(4);
        System.out.println(solve(arr,6));
    }
}
