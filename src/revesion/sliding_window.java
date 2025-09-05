package revesion;

import java.util.HashMap;
import java.util.Map;

public class sliding_window {




    int mod=(int)1e9+7;
    public int rev(int x ){

        if (x<10) return x*10;
        int last=x%10;
        int first=x/10;
        return last*10+first;
    }
    public int countPalindromes(String s) {

        int n = s.length();
        int ans=0;
        int[] fc = new int[10];
        int[] bc = new int[10];

        int[] subFront = new int[100];
        int[] subback = new int[100];


        for (int i = n - 1; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {

                int key = x * 10 + j;
                subback[key] += bc[j];

            }
        }

        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            bc[x]--;
            for (int j = 0; j < 10; j++) {
                int key = x * 10 + j;
                subback[key]--;
            }
            for(int j=0;j<100;j++){
                ans = (int) ((ans + 1L * subFront[j] * subback[rev(j)]) % mod);}

            for (int k=0;k<10;k++){
                subFront[k*10+x]+=fc[k];
            }

            fc[x]++;

        }
        return ans ;
    }



    public static void main(String[] args) {
        System.out.println(1/10);
    }
}
