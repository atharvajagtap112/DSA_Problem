package Leetcode_DailyChanllenge;

public class subarray {
    public static void main(String[] args) {
        int[] arry={1,2,3,4,5};
        for (int i=0;i<arry.length;i++){
            for (int j=i;j< arry.length;j++){
               for (int k=i;k<j;j++){
                   System.out.print(arry[i]);
               }
            }

        }
    }
}
