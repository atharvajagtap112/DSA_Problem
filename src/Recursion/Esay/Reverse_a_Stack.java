package Recursion.Esay;

import java.util.Stack;

public class Reverse_a_Stack {
    static void reverse(Stack<Integer> s){
      if (s.isEmpty()) return;
      int n=s.peek();
      s.pop();
      reverse(s);
      insetAtBottom(n,s);
    }

    private static void insetAtBottom(int n,Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(n);
        }
        int num=stack.peek();
        stack.pop();
        insetAtBottom(n,stack);
        stack.push(num);
    }
}
