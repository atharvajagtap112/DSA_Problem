package Recursion.Esay;

import java.util.Arrays;

public class Generate_all_binary_strings {
    static void func(int k){
        char[] arr=new char[k];
        arr[0]='0';
        generate(k,arr,1);
        arr[0]='1';
        generate(k,arr,1);
    }

    private static void generate(int k, char[] arr, int n) {
        if (k == n) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        if (arr[n-1]=='0') {
            arr[n] = '0';
            generate(k, arr, n + 1);
            arr[n] = '1';
            generate(k, arr, n + 1);
        }
        if (arr[n-1]=='1'){
            arr[n]='0';
            generate(k,arr,n+1);
        }

    }

    public static void main(String[] args) {
        func(3);
    }
}
