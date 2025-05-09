package Stack_And_Queues.medium;

import java.util.Stack;

public class prefix_to_infix {
    static String preToInfix(String pre_exp) {
        Stack<String> st=new Stack<>();
        for (int i=0;i<pre_exp.length();i++){
            char ch=pre_exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) st.push(ch+"");
            else {
                String t1=st.pop();
                String t2=st.pop();
                String t='('+t1+ch+t2+')';
                st.push(t);
            }
        }
        return st.peek();
    }
}
