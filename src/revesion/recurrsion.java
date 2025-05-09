package revesion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class recurrsion {
    public Stack<Integer> sort(Stack<Integer> s) {
       if (s.isEmpty())   return s ;

       int n=s.pop();
        Stack<Integer> stack=sort(s);
       return helper(n,stack);



    }

    private Stack<Integer> helper(int n, Stack<Integer> stack) {
        if (stack.isEmpty()||stack.peek()<n ) {
            stack.push(n);
            return stack;
        }
        int no=stack.pop();
        Stack<Integer> s= helper(n,stack);
        s.push(no);
        return s;

    }

    static void reverse(Stack<Integer> s)
    {
        if (s.isEmpty()) return ;
        int no=s.pop();

        reverse(s);
        reverseHelper(no,s);
        return;
    }

    private static void reverseHelper(int no, Stack<Integer> s) {
        if (s.isEmpty()){
            s.push(no);
            return;

        }
          int n=s.pop();
        reverseHelper(no,s);
        s.push(n);
    }

    static void func(int k) {
        generate(k ,"",0);
    }

    private static void generate(int k, String ch, int index) {
        if (k==index) {
            System.out.println(ch);
            return;
        }

        generate(k,ch+'0',index+1);
        if (ch.isEmpty()||ch.charAt(ch.length()-1)!='1' )
        generate(k,ch+'1',index+1);
    }


    public static List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
           generateparen(n,ans,"(",1,0);
           return ans;
    }

    private static void generateparen(int n, List<String> ans, String s, int i, int j) {
        if (i==n&&j==n){
            ans.add(s);
            return;
        }

        if (i<n){
            generateparen(n,ans,s+'(',i+1,j);
        }
        if (j<i){
            generateparen(n,ans,s+')',i,j+1);
        }


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    List<List<Integer>> ans=new ArrayList<>();
      combinations(candidates,target,ans,new ArrayList<>(),0);
    return ans;
    }

    private void combinations(int[] candidates, int target, List<List<Integer>> ans,List<Integer> ds,int index)

    {if(target<=0){
        if (target==0) ans.add(new ArrayList<>(ds));
        return;
    }

    for (int i=index;i<candidates.length;i++){
        ds.add(candidates[i] );
        combinations(candidates,target-candidates[i],ans,ds,i+1);
        ds.remove(ds.size()-1);

    }

    }

    public static boolean exist(char[][] board, String word) {
        if (board.length==1&&board[0].length==1&&word.length()==1&&board[0][0]==word.charAt(0)) return true;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)&&isExist(i,j,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    static int[][] directions={ { -1,0}, {0,1}, {1,0}, {0,-1}};
    private static boolean isExist(int i, int j, char[][] board, String word, int index) {
        if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='0')  return false;

        if (index==word.length())return true;
        if (board[i][j]!=word.charAt(index))  return false;

        for (int [] ele:directions){
            int row=ele[0];
            int col=ele[1];
            char prev=board[i][j];
            board[i][j]='0';
            if( isExist(i+row, j+col, board, word, index + 1)) return true;
            board[i][j]=prev;
        }


        return false;
    }

    public static void main(String[] args) {
      //func(4);

       // System.out.println( generateParenthesis(3));
//        char[][]board={
//                {'A','B','C','E'},
//                { 'S','F','C','S'},
//                {'A','D','E','E'}
//
//        };
               char[][]board={
                {'a','a'},


        };
        System.out.println(exist(board,"aa"));
    }



    }

