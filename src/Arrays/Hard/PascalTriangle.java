package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    static List<Integer> generateRow(int row){
        List<Integer> rowList=new ArrayList<>();
        rowList.add(1);
        int res=1;
        for (int col=1;col<row;col++){
            res=res*(row-col);
            res=res/col;
            rowList.add(res);

        }

        return rowList;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();


        for (int row=1;row<=numRows;row++){
            list.add(generateRow(row));
        }
        return list;
    }

    public static void main(String[] args) {
        int numsrow=5;
        System.out.println(generate(numsrow));
    }
}
