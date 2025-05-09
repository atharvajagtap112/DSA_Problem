package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I {
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Stack<Integer> stack=new Stack<>();
//      Map<Integer,Integer> map=new HashMap<>();
//      for (int i=nums2.length-1;i>=0;i--){
//          while (!stack.isEmpty()&&stack.peek()<=nums2[i]){
//              stack.pop();
//          }
//          if (stack.isEmpty()) map.put(nums2[i],-1 );
//          else map.put(nums2[i],stack.peek() );
//          stack.push(nums2[i]);
//      }
//    for (int i=0;i<nums1.length;i++){
//        if (map.containsKey(nums1[i])) {
//            nums1[i]=map.get(nums1[i]);
//        }
//    }
//    return nums1;
//    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums1.length;
        int[] ans = new int[n];

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }


}
