package Leetcode_DailyChanllenge;

import java.util.Arrays;

public class Apple_Redistribution_into_Boxes {
    public static int minimumBoxes(int[] apple, int[] capacity) {
        Integer[] cap = Arrays.stream(capacity).boxed().toArray(Integer[]::new);
        Arrays.sort(cap, (a, b) -> b - a);

        int n=apple.length;
        int m=cap.length;
        int i=0;
        int j=0;
        int cnt=0;

        while(i<n&&j<m&&cap[j]!=0){
            if(cap[j]>=apple[i]){
                cap[j]-=apple[i];
                i++;

            }
            else{
                apple[i]-=cap[j];
                cap[j]=0;
                j++;


            }
            if(j<m&&cap[j]==0) j++;

        }
        return j+1;


    }

    public static void main(String[] args) {
        System.out.println(minimumBoxes(new int[]{1,3,2},new int[]{4,3,1,5,2}));
    }
}
