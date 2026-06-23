package Leetcode_DailyChanllenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Find_Sum_of_Array_Product_of_Magical_Sequences {

    public void solved(List<List<Integer>> result, List<Integer> temp, int m, int k, int[] nums, int i) {
        if (temp.size() == m) {
            long val = 0;
            for (int ind : temp) val += (1L << ind);
            if (Long.bitCount(val) == k) result.add(new ArrayList<>(temp));
            return;
        }
        if (i == nums.length) return;

        // take
        temp.add(i);
        solved(result, temp, m, k, nums, i + 1);
        temp.remove(temp.size() - 1);

        // skip
        solved(result, temp, m, k, nums, i + 1);
    }

    public int magicalSum(int m, int k, int[] nums) {
        int MOD = 1_000_000_007;
        List<List<Integer>> result = new ArrayList<>();
        solved(result, new ArrayList<>(), m, k, nums, 0);

        long ans = 0;
        for (List<Integer> list : result) {
            long prod = 1;
            for (int ind : list) {
                prod = (prod * nums[ind]) % MOD;
            }
            ans = (ans + prod) % MOD;
        }
        long finalAns=0;
        for (int i=1;i<=m;i++){
            finalAns=(finalAns+ans)%MOD;
        }
        return (int) finalAns;
    }

    public static void main(String[] args) {

    }
}
