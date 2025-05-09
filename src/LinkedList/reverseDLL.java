package LinkedList;
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class reverseDLL {
    public static Node reverseDLL(Node  head)
    {
        if (head==null||head.next==null)return head;
        Node current=head;
        Node prev=null;
        while (current!=null){
             prev=current.prev;
            current.prev=current.next;
            current.next=prev;
            current=current.prev;
        }
        return prev.prev;
    }
}
