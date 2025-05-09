package Arrays.Hard;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=0;
     for (int i=m;i<nums1.length;i++){
         nums1[i]=nums2[index];
         index++;
     }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int []arr1={0};
        int []arr2={1};
        merge(arr1,0,arr2,arr2.length);

        System.out.println(Arrays.toString(arr1));
    }
}
