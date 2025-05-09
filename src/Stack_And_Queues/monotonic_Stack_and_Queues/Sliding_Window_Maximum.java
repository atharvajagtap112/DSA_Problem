package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq=new ArrayDeque<>();
        int [] max=new int[nums.length-k];

        for (int i=0;i< nums.length;i++){
            if (!dq.isEmpty()&&dq.peek()<=i-k) dq.poll();
            while (!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                max[i-k-1]=dq.peek();
            }
        }
        return max;
    }
}
