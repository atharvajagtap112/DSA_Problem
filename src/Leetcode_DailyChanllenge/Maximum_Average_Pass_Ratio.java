package Leetcode_DailyChanllenge;

public class Maximum_Average_Pass_Ratio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
       int minPassRatioIndex=0;
       double minPassRatio= (double) classes[0][0] / (double)classes[0][1];
         for (int row=0;row<classes.length;row++){
             double passRatio=(double)classes[row][0]/ (double) classes[row][1];

           if(passRatio<minPassRatio){
               minPassRatio=passRatio;
               minPassRatioIndex=row;
           }

        }

         classes[minPassRatioIndex][0]+=extraStudents;
         classes[minPassRatioIndex][1]+=extraStudents;
         double totalPassingRatio=0.0;
         for (int [] a:classes){
             totalPassingRatio+=(double)a[0]/ (double) a[1];
         }
         return totalPassingRatio/ classes.length;
    }

}
