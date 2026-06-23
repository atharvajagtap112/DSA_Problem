package DigitDp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CntNumberOfDigitFrom_l_to_r_number_equal_to_3 {

    static int[][][] dp = new int[20][2][20];


    public static void main(String[] args) {

        resetDP();
        int l = 13 - 1;
        int r = 33;

        int right = solve(String.valueOf(r), 0, 0, 1);
        resetDP();
        int left = solve(String.valueOf(l), 0, 0, 1);

        System.out.println(right - left);
    }

    private static int solve(String s, int idx, int cnt, int tight) {
        if (idx == s.length()) return cnt;
        if (dp[idx][tight][cnt] != -1) return dp[idx][tight][cnt];
        int ans = 0;
        int limt = tight == 1 ? s.charAt(idx) - '0' : 9;
        for (int i = 0; i <= limt; i++) {
            int updateCnt = cnt + (i == 3 ? 1 : 0);
            ans += solve(s, idx + 1, updateCnt, tight == 0 ? 0 : i == s.charAt(idx) - '0' ? 1 : 0);
        }
        return dp[idx][tight][cnt] = ans;
    }

    static void resetDP() {
        for (int i = 0; i < 20; i++) {
            for (int[] arr : dp[i]) {
                Arrays.fill(arr, -1);
            }
        }
    }

}
