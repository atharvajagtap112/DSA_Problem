package String.Easy;

public class Remove_Outermost_Parentheses {
    public static String removeOuterParentheses(String s) {
        char parn1='(';
        int cnt=0;
        String ans="";
        for(int i=0;i<s.length()-1;i++){
           if (s.charAt(i)==parn1){
               if (cnt>0){
                   ans+=s.charAt(i);
               }
               cnt++;
           }
           else {
               cnt--;
               if (cnt>0){
                   ans+=s.charAt(i);
               }

           }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a="(()())(())(()(()))";
        System.out.println(removeOuterParentheses(a));
    }
}
