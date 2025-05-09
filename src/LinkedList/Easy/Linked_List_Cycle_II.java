package LinkedList.Easy;

public class Linked_List_Cycle_II {
    public static int lengthCycle(ListNode head) {
    int length=0;
    int length1=1;
    ListNode f=head;
    ListNode s=head;
    while (f!=null&&f.next!=null){
        f=f.next.next;
        s=s.next; length1++;

        if (f==s){
            break;
        }

    }
    while (s!=null&&s.next!=null){
        s=s.next;

        if (f==s){
            break;
        }
        length++;
    }
    return length1-length;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(6);
        node1.next=node2;
        ListNode node3=new ListNode(7);
        node2.next=node3;
        ListNode node4=new ListNode(8);
        node3.next=node4;
        ListNode node5=new ListNode(9);
        node4.next=node5;
      node5.next=node1;
        System.out.println(lengthCycle(node1));
    }
}
