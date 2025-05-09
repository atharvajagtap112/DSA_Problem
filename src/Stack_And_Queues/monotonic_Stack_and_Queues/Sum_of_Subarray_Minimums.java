package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.Stack;

public class Sum_of_Subarray_Minimums {
    public int sumSubarrayMins(int[] arr) {
        int [] pse=findPSE(arr);
        int [] nse=findNSE(arr);
        int total=0;
        int MOD=1000000007;
        for (int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long sum=(long) left * right * arr[i];;
            sum=sum%MOD;
            total=(total%MOD+(int)sum)%MOD;
        }
        return total;
    }

    private int[] findNSE(int[] arr) {
        int[] nse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()? arr.length:st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] findPSE(int[] arr) {
        int []pse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<arr.length;i++){
            while (!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.empty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
}
