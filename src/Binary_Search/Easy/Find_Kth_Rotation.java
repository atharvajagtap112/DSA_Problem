package Binary_Search.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class Find_Kth_Rotation {
    public static int findKRotation(List<Integer> arr) {
      int index=0;
      int min=arr.get(0);
      int low=0;
      int high=arr.size()-1;
        while (low <= high) {
            int mid=(low+high)/2;
           if (arr.get(low)<=arr.get(mid)){
               if (arr.get(low)<=min){
                   min=arr.get(low);
                   index=low;
               }
               low=mid+1;
           }
           else {
               if (arr.get(mid)<=min){
                   min=arr.get(mid);
                   index=mid;
               }
               high=mid-1;
           }

        }
        return index;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        System.out.println(findKRotation(list));
    }
}
