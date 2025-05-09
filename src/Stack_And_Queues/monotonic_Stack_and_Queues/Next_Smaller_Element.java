package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.ArrayList;
import java.util.Stack;

public class Next_Smaller_Element {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<A.size();i++){
            while (!stack.isEmpty()&&A.get(i)<stack.peek()){
                stack.pop();
            }
            result.add(stack.isEmpty()? -1:stack.peek());
           stack.push(A.get(i));
        }
        return result;
    }
}
