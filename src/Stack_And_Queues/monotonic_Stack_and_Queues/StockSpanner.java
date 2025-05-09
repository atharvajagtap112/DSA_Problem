package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.Stack;

 class Pair<I, V> {
     I index;
     V value;

    public Pair(I key, V value) {
        this.index = key;
        this.value = value;
    }

    public I getIndex() {
        return index;
    }

    public V getValue() {
        return value;
    }
}
public class StockSpanner {

    Stack<Pair<Integer,Integer>> st;
    int index;
    public StockSpanner() {
    this.st=new Stack<>();
    this.index=-1;
    }

    public int next(int price) {
      index++;
        while(!st.empty()&&st.peek().value<=price){
            st.pop();
        }
        int nge=st.empty()? -1:st.peek().index;
        Pair<Integer,Integer> pair=new Pair<>(index,price);
        st.push(pair);

        return index-nge;
    }
}
