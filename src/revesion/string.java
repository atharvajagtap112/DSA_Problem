package revesion;

import java.util.HashMap;
import java.util.Map;

public class string {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        int prefix = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt == 0) {
                ans += s.substring(prefix + 1, i);
                prefix = i + 1;
            }
        }
        return ans;
    }

    public String reverseWords(String s) {
        String ans = "";
        int i;
        String temp = " ";
        s = s.trim();
        for (i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                if (ans == "") ans += temp;
                else ans = temp + " " + ans;
                temp = "";
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
            }
            temp += s.charAt(i);
        }
        if (ans == "") return temp;
        return temp + " " + ans;
    }


//    public String reverseWords(String s) {
//        String ans="";
//        int i;
//        String temp="";
//
//        for (i=0;i<s.length();i++){
//
//            if (s.charAt(i)==' '){
//                if (ans=="") ans=temp;
//                else ans=temp+" "+ans;
//                temp="";
//                while (i<s.length()&&s.charAt(i)==' '){
//                    i++;
//                }
//            }
//            if(i<s.length()&&s.charAt(i)!=' ') temp+=s.charAt(i);
//
//
//        }
//        if(ans=="") return temp;
//        return (temp!="")? temp+" "+ans:ans;
//    }

    public String largestOddNumber(String num) {
     String ans="";
     int i=num.length()-1;
     while (i>=0){
         if ((num.charAt(i)-'0')%2==1) break;
         i--;
     }

    return num.substring(0,i+1);
    }

    public boolean isIsomorphic(String s, String t) {
       Map<Character,Character> map=new HashMap<>();
       int i=0;
       while (s.length()>i&&i<t.length()){
           char key=s.charAt(i);
           char value=s.charAt(i);
           if (map.containsKey(key)){
               if (map.get(key)!=value) return false;
           }
           if (!map.containsKey(key)&& map.containsValue(value)) return false;
          map.put(key,value);
       }
       return true;
    }

    public String longestPalindrome(String s) {
     String ans="";
     for (int i=1;i<s.length();i++){
         int l=i;
         int r=i;
         while (s.charAt(l)==s.charAt(r)){
             l--;
             r++;
             if (l==-1||r==s.length()) break;
         }
         String temp=s.substring(l+1,r);
         if (ans.length()<temp.length()) ans=temp;

       l=i-1;
       r=i;
       while (s.charAt(l)==s.charAt(r)){
           l--;
           r++;
           if (l==-1||r==s.length()) break;
       }
       temp=s.substring(l+1,r);
       if (ans.length()<temp.length()) ans=temp;
     }
     return ans;
    }
    public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode oddEvenList(ListNode head) {
      int cnt=1;
      ListNode temp=head;
      ListNode oddHead=new ListNode(-1);
      ListNode tempOddHead=oddHead;
      ListNode evenHead=new ListNode(-1);
      ListNode tempEvenHead=evenHead;
      while (temp!=null){

          if (cnt%2==0){
              tempEvenHead.next=temp;
              tempEvenHead=tempEvenHead.next;
          }
          else{
              tempOddHead.next=temp;
              tempOddHead=tempEvenHead.next;
          }
          cnt++;
         temp=temp.next;
      }
      tempEvenHead.next=null;
      tempOddHead.next=evenHead.next;
      return oddHead.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
     removeFromEnd(head,n);

     return head;
    }

    private int removeFromEnd(ListNode temp, int n) {
        if (temp.next==null) {
            return n-1;
        };
       int cnt= removeFromEnd(temp.next,n);
       if (cnt==0){
           temp.next=temp.next.next;
       }
        return cnt-1;
    }
    public ListNode deleteMiddle(ListNode head) {
        if (head.next==null)return head;
    ListNode slow=head;
    ListNode prevSlow=slow;
    ListNode fast=head;
    while (fast.next!=null&&fast!=null){
        prevSlow=slow;
        slow=slow.next;
        fast=fast.next.next;
    }
    prevSlow.next=prevSlow.next.next;
    return head;
    }

    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }

    static Node deleteAllOccurOfX(Node head, int x) {
     Node temp=head;
     Node prev=temp;
     while (temp!=null){
        if(temp.data==x){
         while (temp!=null&&temp.data==x){
             temp=temp.next;
         }
        if (head.data==x) head=temp;
        else {
            prev.next=temp;
            if(temp!=null)temp.prev=prev;
        }
        }
        prev=temp;
         if(temp!=null) temp=temp.next;

     }

    return head;
    }

    static Node removeDuplicates(Node head){
        Node temp=head;
        Node prev=temp;
        while (temp!=null){
            if (temp.next!=null&&temp.data== temp.next.data){
                int target=temp.data;
                while (temp!=null&&temp.data==target){
                    temp=temp.next;
                }
                prev.next=temp;
                temp.prev=prev;
            }
            prev=temp;
            if(temp!=null)temp=temp.next;
        }
        return head;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//      k-=1;
//      int cnt=0;
//    ListNode crnt=head;
//    ListNode prev=crnt;
//    ListNode firstNode=crnt;
//    ListNode next=crnt;
//    while (crnt!=null) {
//        if (cnt==0){
//            prev=crnt;
//        }
//    crnt=crnt.next;
//    cnt++;
//
//    if (cnt==k){
//        next=crnt.next;
//        crnt.next=null;
//        ListNode node=reverseNode(prev);
//        if (prev==head){
//            head=node;
//
//            crnt=next;
//            cnt=0;
//        }
//        else {
//            prev.next=node;
//
//            cnt=0;
//            crnt=next;
//
//        }
//
//    }
//
//    }
//    }
}