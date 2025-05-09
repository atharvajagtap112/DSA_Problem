package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream {
//    class MedianFinder {
//
//
//        PriorityQueue<Integer> pq;
//        public MedianFinder() {
//            this.pq=new PriorityQueue<>();
//        }
//
//        public void addNum(int num) {
//            pq.add(num);
//
//        }
//
//        public double findMedian() {
//
//             int first=0;
//             int second=0;
//             ArrayList<Integer> list=new ArrayList<>();
//           for (int i=0;i<=pq.size()/2;i++){
//               list.add(pq.poll());
//           }
//           if (pq.size()%2==0){
//               return  ( (double) list.get(list.size()-1)+(double) list.get(list.size()-2))  /2 ;
//           }
//
//           return (double) list.get( list.size()-1);
//
//        }
//    }




    class MedianFinder {
           PriorityQueue<Integer> maxHeap;
           PriorityQueue<Integer> minHeap;
        public MedianFinder() {
           this.maxHeap=new PriorityQueue<>();
           this.minHeap=new PriorityQueue<>();
        }

        public void addNum(int num) {
         if(maxHeap.isEmpty()|| maxHeap.peek()>num) maxHeap.add(num);
         else minHeap.add(num);

         if (maxHeap.size()>minHeap.size()+1){
             minHeap.add(maxHeap.poll());
         }
         else if(maxHeap.size()<minHeap.size() ){
             maxHeap.add(minHeap.poll());
         }
        }

        public double findMedian() {
           if (maxHeap.size()==minHeap.size()){
               return maxHeap.peek()/2.0+minHeap.peek()/2.0;
           }
           return maxHeap.size()/2.0;
        }
    }

}
