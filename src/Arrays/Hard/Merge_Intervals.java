package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        //sort the given intervals:
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>>ans=new ArrayList<>();
 for (int i=0;i<intervals.length;i++){
     if (ans.isEmpty()||intervals[i][0]>ans.get(ans.size()-1).get(1)){
       ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
     }
     else {
         ans.get(ans.size() - 1).set(ans.size()-1,Math.max(ans.get(ans.size()-1).get(1),intervals[i][1]) );
     }
 }
 int [][]arr=new int [ans.size()][2];
 for (int i=0;i<ans.size();i++){
     arr[i][0]=ans.get(i).get(0);
     arr[i][1]=ans.get(i).get(1);
 }

 return  arr;
    }

    public static void main(String[] args) {
        int [][]arr={
            {1,3 },
            {2,6 },
            { 8,10},
            { 15,18},

        };
       for (int[]a:merge(arr)){
           System.out.println(Arrays.toString(a));
       }
    }
}
