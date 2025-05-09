package LinkedList;

class DlNode{
    int value;
    DlNode next;
    DlNode prev;

    public DlNode(int value) {
        this.value = value;
        this.next=null;
        this.prev=null;
    }

    public DlNode(int value, DlNode next,DlNode prev) {
        this.value = value;
        this.next = next;
        this.prev=prev;
    }
}
public class DLL {
  static DlNode head;
   public static DlNode convertArr2DLL(int []arr){
      head=new DlNode(arr[0],null,null) ;
      DlNode temp=head;
      for (int i=1;i<arr.length;i++){
          DlNode x=new DlNode(arr[i],null,temp);
          temp.next=x;
          temp=x;

      }
      return head;
   }
   static void print(DlNode head){
       DlNode temp=head;
       while (temp!=null){
           System.out.print(temp.value+"-->");
        temp=temp.next;
       }

   }
   static DlNode removeKthElement(DlNode head,int k){
       DlNode temp=head;
       int cnt=0;
       while (temp!=null){
         cnt++;
         if (cnt==k) break;
         temp=temp.next;
       }
       DlNode prev=temp.prev;
       DlNode front=temp.next;
       if (prev==null&&front==null) return null;
       else if (prev==null) return temp.next;
       else  if( front==null) {
           temp.prev.next=null;
           temp.prev=null;
       }
       else {
           prev.next=front;
           front.prev=prev;
           temp.next=null;
           temp.prev=null;
       }
       return head;
   }
   static DlNode insertBeforHead(DlNode head, int value){

       DlNode newNode=new DlNode(value,head,null);
       head=newNode;
       return head;
   }
   static DlNode insertBeforeTail(DlNode head,int value){
       DlNode temp=head;
       if (head.next==null){
           return insertBeforHead(head,value);
       }
       while (temp.next!=null){
           temp=temp.next;
       }
       DlNode prev=temp.prev;
       DlNode newNode=new DlNode(value,temp,prev);
       prev.next=newNode;
       temp.prev=newNode;

       return head;
   }
 static DlNode insertBeforeKthEle(DlNode head,int value,int k){
       if (k==1) return insertBeforHead(head,value);
          DlNode temp=head;
          int cnt=0;
          while (temp!=null){
               cnt++;
               if (k==cnt){
                   DlNode prev=temp.prev;
                   DlNode newNode=new DlNode(value,temp,prev);
                   prev.next=newNode;
                   temp.prev=newNode;

               }
               temp=temp.next;
          }
          return head;
 }
static void insertBeforeNode(DlNode node ,int value){
       DlNode prev=node.prev;
     DlNode newNode=new DlNode(value,node,prev);
     prev.next=newNode;
     node.prev=newNode;
}
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        DlNode head=convertArr2DLL(arr);
      //  head=removeKthElement(head,5);
        //head= insertBeforHead(head,10);
        // head=insertBeforeTail(head,55);
         //head=insertBeforeKthEle(head,10,3);

         insertBeforeNode(head.next.next.next,78);
        print(head);
    }

}
