package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.Stack;

public class Sum_of_Subarray_Ranges {
    public long subArrayRanges(int[] nums) {
           return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {
        int [] pse=findPSE(arr);
        int [] nse=findNSE(arr);
        long total=0;
        int MOD=1000000007;
        for (int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long sum=(long) left * right * arr[i];;

            total=total+sum;
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

    public long sumSubarrayMaxs(int[] arr) {
        int [] pse=findPGE(arr);
        int [] nse=findNGE(arr);
        long total=0;
        int MOD=1000000007;
        for (int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long sum=(long) left * right * arr[i];;

            total=total+sum;
        }
        return total;
    }

    private int[] findNGE(int[] arr) {
        int[] nge=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty()&&arr[st.peek()]<=arr[i]){
                st.pop();
            }
            nge[i]=st.isEmpty()? arr.length:st.peek();
            st.push(i);
        }
        return nge;
    }

    private int[] findPGE(int[] arr) {
        int []pge=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<arr.length;i++){
            while (!st.isEmpty()&&arr[st.peek()]<arr[i]){
                st.pop();
            }
            pge[i]=st.empty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }
}
