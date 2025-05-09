package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.Stack;

public class Maximal_Rectangle {
    public static int maximalRectangle(char[][] matrix) {
        int maxArea=0;
          int [][] pSum=new int[matrix.length][matrix[0].length];
        for (int col=0;col<matrix[0].length;col++){
            int sum=0;
            for (int row=0;row<matrix.length;row++){
                sum+=matrix[row][col]-'0';
                if (matrix[row][col]=='0'){
                    sum=0;
                }
                pSum[row][col]=sum;
            }
        }

        for (int [] arr:pSum){
            maxArea=Math.max(maxArea, largestRectangleArea(arr));
        }
        return maxArea;
    }


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
         char[][] arr={
                {'1','0','1','0','1' },
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}

        };
        System.out.println(maximalRectangle(arr));
    }
}
