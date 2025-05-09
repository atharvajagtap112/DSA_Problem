package LinkedList.Easy;

import java.util.Stack;

public class Add_1_to_a_Linked_List_Number {
    private int helper(Node temp) {
      if (temp==null) return 1;

      int carry=helper(temp.next);
      temp.data=temp.data+carry;
      if (temp.data<10){
          return 0;
      }
      temp.data=0;
      return 1;
    }
    public Node addOne(Node head) {
     int carry=helper(head);
     if (carry==1){
         Node newHead=new Node(1);
         newHead.next=head;
         return newHead;
     }
     return head;
    }


}
