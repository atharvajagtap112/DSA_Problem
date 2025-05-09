package Stack_And_Queues.medium;

import java.util.Stack;

public class Prefix_to_Postfix_Conversion {
    static String preToPost(String pre_exp) {
        Stack<String> st = new Stack<>();
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) st.push(ch + "");
            else {
                String t1 = st.pop();
                String t2 = st.pop();
                st.push(t1 + t2 + ch);
            }

        }
        return st.peek();

    }
}
