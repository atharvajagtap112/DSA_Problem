package Leetcode_DailyChanllenge;

public class Design_Spreadsheet {
    class Spreadsheet {
        int[][] matrix;

        public Spreadsheet(int rows) {
            matrix=new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int col=cell.charAt(0)-'A';
            int row=Integer.parseInt(cell.substring(1));
            matrix[row-1][col]=value;
        }

        public void resetCell(String cell) {
            int col=cell.charAt(0)-'A';
            int row=Integer.parseInt(cell.substring(1));
            matrix[row-1][col]=0;
        }

        public int getValue(String formula) {
            int ind=0;
            StringBuilder first=new StringBuilder();
         for (int i=0;i<formula.length();i++){
             if (formula.charAt(i)=='+'){
                 ind=i;
                 break;
             }
             first.append(formula.charAt(i));
         }

         int val1=0;
         int val2=0;
         if (Character.isLetter(first.charAt(0))){
             int firstCol=first.charAt(0)-'A';
             int firstRow= Integer.parseInt(first.substring(1));
             val1=matrix[firstRow][firstCol];
         }
         else val1=Integer.parseInt(first.toString());

         if (Character.isLetter(formula.charAt(ind+1))){
             int secCol=formula.charAt(ind+1)-'A';
             int secRow=Integer.parseInt(formula.substring(ind+2));
             val2=matrix[secRow][secCol];
         }
         else val2=Integer.parseInt(formula.substring(ind+2));
         return val1+val2;

        }
    }

}
