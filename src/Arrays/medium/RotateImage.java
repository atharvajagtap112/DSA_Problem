package Arrays.medium;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
int n=matrix.length;
for (int i=0;i<n-1;i++){
    for (int j=i+1;j<n;j++){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

}
for (int i=0;i<n;i++){
    reverse(matrix,i);
}
    }
static void reverse(int[][]matrix,int row){
    int start=0;
    int end=matrix.length-1;
    while (start<end){
        int temp=matrix[row][start];
        matrix[row][start]=matrix[row][end];
        matrix[row][end]=temp;
        start++;
        end--;
    }

    }

    public static void main(String[] args) {
        int [][]a={
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16},
        };
        rotate(a);
        for (int []b:a){
            System.out.println(Arrays.toString(b));
        }
    }

}
