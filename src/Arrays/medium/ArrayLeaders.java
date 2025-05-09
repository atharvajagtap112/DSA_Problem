package Arrays.medium;

import java.util.ArrayList;

public class ArrayLeaders {
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> ans=new ArrayList<>();
        int el=arr[n-1];
        for (int i=n-1;i>=0;i--){
            if (el<=arr[i]){
                ans.add(arr[i]);
                el=arr[i];
            }
        }
        return reverse(ans);
    }
    public static ArrayList<Integer> reverse(ArrayList<Integer> list){
        int start= 0;
        int end= list.size()-1;
        while (start<end){
            int temp=list.get(start);
            list.set(start, list.get(end));
            list.set(end,temp);
            start++;
            end--;

        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr={16,17,4,3,5,2};
        System.out.println(leaders(arr.length,arr));
    }
}
