package LinkedList.Easy;

public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead1=l1;
        ListNode tempHeda2=l2;
        ListNode NewHead=new ListNode(-1);
        ListNode temp=NewHead;
        int carry=0;
        while (tempHead1!=null||tempHeda2!=null){
            int sum=0;
            if (tempHead1!=null){
                 sum+=tempHead1.val;
                tempHead1=tempHead1.next;
            }
            if (tempHeda2!=null){
                sum+= tempHeda2.val;
                tempHeda2=tempHeda2.next;
            }
             sum+=carry;

            if (sum<10){
                ListNode newNode=new ListNode(sum);
                temp.next=newNode;
                temp=newNode;
                carry=0;
            }
            else{
                carry=sum/10;
                ListNode newNode=new ListNode(sum%10);
                temp.next=newNode;
                temp=newNode;
            }


        }


        if (carry!=0){
            ListNode newNode=new ListNode(carry);
            temp.next=newNode;

        }

        return NewHead.next;
    }
}

