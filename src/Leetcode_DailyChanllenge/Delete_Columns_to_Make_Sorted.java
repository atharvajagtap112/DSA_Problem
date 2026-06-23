package Leetcode_DailyChanllenge;

public class Delete_Columns_to_Make_Sorted {

    public static int minDeletionSize(String[] strs) {
        int n=strs.length;
        boolean[] cols=new boolean[strs[0].length()];

        for(int i=1;i<n;i++){
            String prevS=strs[i-1];
            String currS=strs[i];

            for(int j=0;j<prevS.length();j++){
                if(cols[j]) continue;

                if(prevS.charAt(j)>currS.charAt(j)) cols[i]=true;
            }
        }

        int cnt=0;
        for(boolean col:cols) {
            if(col==true) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }
}
