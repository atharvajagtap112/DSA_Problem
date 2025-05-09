package Stack_And_Queues;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
      for (int i=0;i<s.length();i++){
          char ch=s.charAt(i);
          if (ch==')'||ch=='}'||ch==']'){
              if (stack.isEmpty()) return false;
              char popedEle=stack.pop();
              if (popedEle=='['&&ch!=']'||popedEle=='('&&ch!=')'||popedEle=='{'&&ch!='}') return false;
          }
          else stack.push(ch);
      }
      if (!stack.isEmpty())return false;
        return true;
    }
}
