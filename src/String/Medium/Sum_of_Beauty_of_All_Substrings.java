package String.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
  }
public  class Sum_of_Beauty_of_All_Substrings {
//    public static int beautySum(String s) {
// int left=0;
// int right=1;
//
// int ans=0;
//        boolean isdistinct=false;
// while (left<=right){
//     int maxferq=0;
//     int minfreq=Integer.MAX_VALUE;
//     Map<Character,Integer> map=new HashMap<>();
//     String substring=s.substring(left,right);
//
//     char check=s.charAt(left);
//
//if (!isdistinct){
//     for (int i=left;i<s.length();i++) {
//         if (s.charAt(i) != check) {
//
//             right = i + 1;
//             substring = s.substring(left, right);
//             isdistinct=true;
//             break;
//         }
//     }
//     }
//if (!isdistinct){
//    break;
//}
//
//     for (char key:substring.toCharArray()){
//         map.put(key,map.getOrDefault(key,0)+1);
//         minfreq=Math.min(minfreq,map.get(key));
//         maxferq=Math.max(maxferq,map.get(key));
//
//     }
//     ans+=maxferq-minfreq;
//     right++;
//     if (right>=s.length()+1){
//   isdistinct=false;
//         left++;
//         right=left+1;
//     }
//     if (left==s.length()-1) break;
// }
//
//  return ans;
//    }
public static int beautySum(String s) {
    int ans=0;
    for (int i=0;i<s.length();i++){
        int [] alpha=new int[26];
        for (int j=i;j<s.length();j++){
            alpha[s.charAt(j)-'a']++;
            ans+=beauty(alpha,s);
        }
    } 
    return ans;
}

    private static int beauty(int[] alpha,String s) {
    int min=Integer.MAX_VALUE;
    int max=0;
    for (int i=0;i<alpha.length;i++){
        max=Math.max(alpha[i],max);
        if (alpha[i]>=1){
            min=Math.min(alpha[i],min);
        }
    }
    return max-min;
    }

    public static void main(String[] args) {
        String s="aabcb";
        System.out.println(beautySum(s));
    }
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null)return null;
        if(head.next.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next.next;
        while (fast.next!=null||fast!=null){
            if (slow==fast)return slow;
            if (fast==null||fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;
            if (fast==head)return fast;
            if (slow==fast) break;


        }

        return fast;
    }



}
