package Leetcode_DailyChanllenge;

import java.util.*;

public class Diagonal_Traverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<Integer> temp=map.getOrDefault(i+j,new ArrayList<Integer>());
                temp.add(mat[i][j]);
            }
        }

        int[] ans=new int[n*m+1];

        int i=0;
        for (int j=0;j<=m+n-2;j++){
            List<Integer> temp=map.get(j);
            if (j%2==0){
                Collections.reverse(temp);
            }
            for (Integer no:temp){
                ans[i]=no;
                i++;
            }
        }
        return ans;
    }
}
