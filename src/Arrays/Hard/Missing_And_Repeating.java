package Arrays.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Missing_And_Repeating {
    static int[] findTwoElement(int arr[], int n) {
        int[]ans=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        long TlSum=n*(n+1)/2;
        long sum=0;
        long twice=0;
        int i=0;
        int j=n-1;
        while (i<=j){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);

            if (map.containsKey(arr[i])&&map.get(arr[i])==1){
                sum+=arr[i];
            } if(i!=j){
                map.put(arr[j], map.getOrDefault(arr[j],0)+1);}
            if (i!=j&&map.containsKey(arr[j])&&map.get(arr[j])==1){
                sum+=arr[j];
            }
            if(map.containsKey(arr[i])&&map.get(arr[i])==2){
                twice=arr[i];
            }
            else if((map.containsKey(arr[j])&&map.get(arr[j])==2)) {
                twice=arr[j];
            }
            i++;
            j--;
        }
        ans[0]=(int)twice;
        ans[1]=(int)(TlSum-sum);
        return ans;
    }


//    int[] findTwoElement(int arr[], int n) {
//        int[]ans=new int[2];
//        Map<Integer,Integer> map=new HashMap<>();
//        long TlSum=n*(n+1)/2;
//        long sum=0;
//        long twice=0;
//        int i=0;
//        int j=n-1;
//        while (i<=j){
//            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
//
//            if (map.containsKey(arr[i])&&map.get(arr[i])==1){
//                sum+=arr[i];
//            } if(i!=j){
//                map.put(arr[j], map.getOrDefault(arr[j],0)+1);}
//            if (i!=j&&map.containsKey(arr[j])&&map.get(arr[j])==1){
//                sum+=arr[j];
//            }
//            if(map.containsKey(arr[i])&&map.get(arr[i])==2){
//                twice=arr[i];
//            }
//            else if((map.containsKey(arr[j])&&map.get(arr[j])==2)) {
//                twice=arr[j];
//            }
//            i++;
//            j--;
//        }
//        ans[0]=(int)twice;
//        ans[1]=(int)(TlSum-sum);
//        return ans;
//    }
    public static void main(String[] args) {
        int []arr={1,3,3};
        System.out.println(Arrays.toString(findTwoElement(arr, arr.length)));
    }
}
