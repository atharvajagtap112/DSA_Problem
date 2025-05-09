package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
      return generate(1,0,n,"(",new ArrayList<>());
    }

    private List<String> generate(int i, int j, int n, String s,List<String> list) {
        if (i==j){
            list.add(s);
            return list;
        }
        if (i<=n){
            generate(i+1,j,n,s+'(',list);
        }
        if (j<=n){
            generate(i,j+1,n,s+')',list);
        }
        return list;
    }
}
