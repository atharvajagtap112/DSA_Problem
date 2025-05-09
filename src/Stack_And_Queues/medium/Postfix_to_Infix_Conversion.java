package Stack_And_Queues.medium;

import java.util.Stack;

public class Postfix_to_Infix_Conversion {
    static  String postToInfix(String exp) {
        Stack<String> stack=new Stack<>();
        for (int i=0;i<exp.length();i++){
             char ch=exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) stack.push(String.valueOf(ch));
            else {
                String t1=stack.pop();
                String t2=stack.pop();
                String pushh='('+t2+ch+t1+')';
                stack.push(pushh);
            }

        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String st="ab*c+";
        System.out.println(postToInfix(st));
    }
}
