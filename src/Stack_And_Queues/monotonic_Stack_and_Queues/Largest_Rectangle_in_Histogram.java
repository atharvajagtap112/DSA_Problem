package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
//    public static int largestRectangleArea(int[] heights) {
//        int[] nse=findNSE(heights);
//        int[] pse=findPSE(heights);
//        int area=0;
//        for (int i=0;i<heights.length;i++){
//            int right=nse[i]-i;
//            int left=(i-pse[i])-1;
//            area=Math.max(area,((right+left)*heights[i]));
//        }
//        return area;
//    }
//
//    private static int[] findNSE(int[] heights) {
//        Stack<Integer>st=new Stack<>();
//        int []nse=new int[heights.length];
//        for (int i= heights.length-1;i>=0;i--){
//            while (!st.empty()&&heights[st.peek()]>heights[i]) {
//                st.pop();
//            }
//            nse[i]=st.empty()? heights.length:st.peek();
//            st.push(i);
//        }
//        return nse;
//    }
//
//    private static int[] findPSE(int[] heights) {
//        Stack<Integer>st=new Stack<>();
//        int []pse=new int[heights.length];
//        for (int i=0;i< heights.length;i++){
//            while (!st.empty()&&heights[st.peek()]>heights[i]) {
//                st.pop();
//            }
//            pse[i]=st.empty()? -1:st.peek();
//            st.push(i);
//        }
//        return pse;
//    }



    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>(); int maxArea=0;
        for (int i=0;i< heights.length;i++){
            while (!st.empty()&&heights[st.peek()]>heights[i]){
                int nse=i; int element=heights[st.pop()];
                int pse=st.empty()? -1: st.peek();
                maxArea=Math.max(maxArea,(nse-pse-1)*element );
            }
            st.push(i);
        }
        while (!st.empty()){
            int nse=heights.length;
            int element=heights[st.pop()];
            int pse=st.empty()?-1:st.peek();
            maxArea=Math.max(maxArea, (nse-pse-1)*element);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int []arr={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}
