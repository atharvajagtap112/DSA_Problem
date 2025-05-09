package LinkedList.Medium;

import java.util.ArrayList;

public class Find_pairs_with_given_sum_in_doubly_linked_list {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        Node left=head;
        Node right=findTail(head);
        while (left.data< right.data){
            int sum=left.data+ right.data;
            if (sum==target){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                list.add(temp);
                left=left.next;
                right=right.prev;
            }
            else if (sum>target) {
                right=right.prev;

            }
            else {
                left=left.next;
            }
        }
        return list;
    }

    private static Node findTail(Node head) {
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
}
