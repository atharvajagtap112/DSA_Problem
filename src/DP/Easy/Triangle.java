package DP.Easy;

import java.util.ArrayList;
import java.util.List;

public class Triangle {


    public int fun1(int row,int col,List<List<Integer>> triangle){
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }


        int left=fun1(row+1,col,triangle);
        int right=fun1(row+1,col+1,triangle);


        return triangle.get(row).get(col)+Math.min(left,right);
    }
    public int minimumTotal1(List<List<Integer>> triangle) {


        return fun1(0,0,triangle);
    }
    public int fun2(int row,int col,List<List<Integer>> triangle,List<List<Integer>> dp){
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp.get(row).get(col)!=-1) return dp.get(row).get(col);

        int left=fun2(row+1,col,triangle,dp);
        int right=fun2(row+1,col+1,triangle,dp);

         dp.get(row).add(col, triangle.get(row).get(col)+Math.min(left,right));
        return triangle.get(row).get(col)+Math.min(left,right);
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        List<List<Integer>> dp=new ArrayList<>();
        for (List<Integer> row:triangle){
            List<Integer> list=new ArrayList<>();
            for (int col:row){
                list.add(-1);
            }
            dp.add(list);
        }
        return fun2(0,0,triangle,dp);
    }


    public int minimumTotal3(List<List<Integer>> triangle) {
        List<List<Integer>> dp=new ArrayList<>();

        for (List<Integer> row:triangle){
            List<Integer> list=new ArrayList<>();
            for (int col:row){
                list.add(0);
            }
            dp.add(list);
        }
        int n=triangle.size();
        for(int i=0;i<triangle.get(n-1).size();i++ ){
            dp.get(n-1).add(i,triangle.get(n-1).get(i));
        }


        for (int row=n-2;row>=0;row--){
            int m=triangle.get(row).size();
            for (int col=0;col<m;col++){
                int left=triangle.get(row).get(col)+dp.get(row+1).get(col);
                int right=triangle.get(row).get(col)+dp.get(row+1).get(col+1);

                dp.get(row).add(col,Math.min(left,right));
            }
        }

        return dp.get(0).get(0);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n=triangle.size();
        List<Integer> prev = new ArrayList<>(triangle.get(n - 1));


        for (int row=n-2;row>=0;row--){
            int m=triangle.get(row).size();
            List<Integer> temp=new ArrayList<>();
            for (int col=0;col<m;col++){
                int left=triangle.get(row).get(col)+prev.get(col);
                int right=triangle.get(row).get(col)+prev.get(col+1);

                temp.add(col,Math.min(left,right));
            }
            prev=temp;
        }

        return prev.get(0);
    }

}
