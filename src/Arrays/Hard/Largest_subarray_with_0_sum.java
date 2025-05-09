package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class Largest_subarray_with_0_sum {
    static int maxLen(int arr[], int n){
        HashMap<Integer,Integer> map=new HashMap<>();
        int largest=0;
        int sum=0;
        for (int i=0;i<n;i++){
            sum=sum+arr[i];
            if (sum==0){
                largest=Math.max(largest,i+1);
            }
            else if (map.containsKey(sum)){
                largest=Math.max(largest,i-map.get(sum));
            }
            else {
            map.put(sum,i);}
        }
        return largest;
    }

    public static void main(String[] args) {
        int []arr={15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(arr,arr.length));
    }
}
