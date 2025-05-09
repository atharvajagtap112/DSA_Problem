package LinkedList.Medium;

public class Remove_duplicates_from_a_sorted_doubly_linked_list {

    static Node removeDuplicates(Node head){
   Node temp=head;
   while (temp!=null&&temp.next!=null){
       Node nextnode=temp.next;
       while (nextnode!=null&&nextnode.data== temp.data){
           nextnode=nextnode.next;
       }
       temp.next=nextnode;
       if (nextnode!=null){
           nextnode.prev=temp;
       }
       temp=temp.next;
   }
   return head;
    }

    public static void main(String[] args) {
        Node node1=new Node(1);

        Node node2=new Node(1);
        node1.next=node2;
        node1.prev=null;
        Node node3=new Node(1);
        node2.next=node3;
        node2.prev=node1;
        Node node4=new Node(2);
        node3.next=node4;
        node3.prev=node2;
        Node node5=new Node(3);
        node4.next=node5;
        node4.prev=node3;
        Node node6=new Node(4);
       node5.next=node6;
       node5.prev=node4;
       node6.prev=node5;
       node6.next=null;
       Node a=removeDuplicates(node1);
       Node temp=a;
       while (temp!=null){
           System.out.println(temp.data);
           temp=temp.next;
       }
    }
}
