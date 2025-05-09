package LinkedList.Medium;
class Node{
    int data;
    Node next;
  Node prev;

    public Node(int data) {
        this.data = data;
        this.next=null;
        this.prev=null;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev=prev;
    }
}

public class Delete_aoccurrences_of_a_given_key_in_a_doubly_linked_list {

    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp=head;

        while (temp!=null){
            if (temp.data ==x){
                if (temp==head){
                    head=temp.next;
                }
                Node prev=temp.prev;
                Node front=temp.next;
                if (prev!=null) prev.next=front;
                if (front!=null) front.prev=prev;
                temp=temp.next;
            }
            else {
            temp=temp.next;}
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1=new Node(7);

        Node node2=new Node(2);
        node1.next=node2;
        node1.prev=null;

        Node node3=new Node(5);
        node2.next=node3;
        node2.prev=node1;
        Node node4=new Node(4);
        node3.next=node4;
        node3.prev=node2;
        Node node5=new Node(2);
        node4.next=node5;
        node4.prev=node3;
        Node node6=new Node(2);
        node5.next=node6;
        node5.prev=node4;
        node6.prev=node5;
        node6.next=null;
        Node temp=deleteAllOccurOfX(node1,2);
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
