package LinkedList.Easy;

public class Sort_a_linked_list_of_0s_1s_and_2s {
    static Node segregate(Node head) {
        if (head==null||head.next==null)return head;
        Node temp=head;

        Node zeroHead=new Node(-1);
        Node zero=zeroHead;

        Node oneHead=new Node(-1);
        Node one=oneHead;

        Node twoHead=new Node(-1);
        Node two=twoHead;

        while (temp!=null){
            if (temp.data==0){
                zero.next=temp;
                zero=zero.next;

            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;

            }
            else {
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
        one.next=twoHead.next;
        two.next=null;
        Node newHead=zeroHead.next;
        return newHead;
    }
}
