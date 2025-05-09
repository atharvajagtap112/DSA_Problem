package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.Stack;

public class Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();


        for (int  i=0;i<num.length();i++){
            while (!st.empty()&&k>0&&st.peek()-'0'>num.charAt(i)-'0'){
                st.pop();
                k--;
            }
        }
        if (st.empty()) return "0";
        while (!st.empty()&&k>0) {
            st.pop();
            k--;
        }
        StringBuilder res=new StringBuilder();
        while (!st.empty()){
            res.append(st.pop());
        }
       for(int i=res.length()-1;i>=0;i--){
           if (res.charAt(i)!='0') break;
           res.delete(i,i+1);
       }
       return res.reverse().toString();
    }

}
