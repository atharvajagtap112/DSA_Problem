package Stack_And_Queues.medium;

import java.util.Stack;

public class Postfix_to_Prefix_Conversion {
    static String postToPre(String post_exp) {
        Stack<String > st=new Stack<>();
        for (int i=0;i<post_exp.length();i++){
            char ch=post_exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) st.push(ch+"");
            else {
                String t1=st.pop();
                String t2=st.pop();
                st.push(ch+t2+t1);
            }
        }
        return st.peek();
    }
}
