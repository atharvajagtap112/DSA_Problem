package Stack_And_Queues.Implementation_Problem;


import java.util.HashMap;
import java.util.Map;



class DLLNode{
    int value;
    int key;
    int frequency;
    DLLNode next;
    DLLNode prev;
    public DLLNode(int key, int value ){
        this.key=key;
        this.frequency =1;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
}




class LFUCache {
    Map<Integer,DLLNode> cache;
    Map<Integer,DoubleLinkedList> frequencyMap;
    int minFrequency;
    int curSize;
    int capacity;
    public LFUCache(int capacity){
        this.cache=new HashMap<>();
        this.frequencyMap =new HashMap<>();
        this. minFrequency=0;
        this.curSize=0;
        this.capacity=capacity;
    }

    public int get(int key) {
        DLLNode node=cache.get(key);
        if (node==null){
            return -1;
        }
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {


        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);

                curSize--;
            }
            minFrequency=1;
            DLLNode newNode=new DLLNode(key,value);
            DoubleLinkedList list= frequencyMap.getOrDefault(1,new DoubleLinkedList());
            list.addNode(newNode);
            cache.put(key,newNode);
            frequencyMap.put(1,list);

        }
    }


    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        curNode.frequency++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }
}


class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;
    public DoubleLinkedList() {
        this.listSize = 0;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /** add new node into head of list and increase list size by 1 **/
    public void addNode(DLLNode curNode) {
        DLLNode nextNode = head.next;
        curNode.next = nextNode;
        curNode.prev = head;
        head.next = curNode;
        nextNode.prev = curNode;
        listSize++;
    }

    /** remove input node and decrease list size by 1**/
    public void removeNode(DLLNode curNode) {
        DLLNode prevNode = curNode.prev;
        DLLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }

}
