package DP.Pattern_Dp.MCM;

public class recurr {

    static int fun(int i,int j,int[] arr){
        if (i==j) return 0;

        int min= (int) 1e9;
        for (int k=i;k<j;k++){
            int step=arr[i-1]*arr[k]*arr[j]+fun(i,k,arr)+fun(k+1,j,arr);
            min=Math.min(min,step);
        }
        return min;
    }

    static int matrixMultiplication(int arr[]) {
        int n=arr.length;
        return fun(1,n-1,arr);

    }
}
