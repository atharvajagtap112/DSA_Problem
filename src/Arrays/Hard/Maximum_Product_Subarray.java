package Arrays.Hard;

public class Maximum_Product_Subarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length; //size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= nums[i];
            suff *= nums[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }

        return ans;
    }

    public static void main(String[] args) {
        int []nums={0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        System.out.println(maxProduct(nums));
    }

}
