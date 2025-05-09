package Stack_And_Queues;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    int mini=Integer.MAX_VALUE;
    public MinStack() {
        this.st=new Stack<>();

    }

    public void push(int val) {
    if (st.isEmpty()) {
        st.push(val);
        mini=val;
    }
    else {
        if (val>mini) st.push(mini);
        else {
            st.push(2*val-mini);
            mini=val;
        }
    }

    }

    public void pop() {
      if (st.isEmpty()) return;
      int x=st.pop();
      if (x>mini) st.pop();
      else {
          mini=2*mini-x;
      }
    }

    public int top() {
       int x=st.peek();
       if(x>mini) return x;
       return mini;
    }

    public int getMin() {
          return mini;
    }
}
