package Leetcode_DailyChanllenge;

import java.util.*;

public class Implement_Router {
    class Router {
        Queue<String> queue=new LinkedList<>();
        int size=0;
        Map<String,int[]> map=new HashMap<>();
        Map<Integer,List<Integer>> distMap=new HashMap<>();

        public Router(int memoryLimit) {
        size=memoryLimit;
        }



        public boolean addPacket(int source, int destination, int timestamp) {
            String s=Integer.toString(source)+"_"+Integer.toString(destination)+"_"+Integer.toString(timestamp);
            if (map.containsKey(s))return false;

            if (queue.size()>=size){
                  forwardPacket();
               }

            queue.add(s);
            map.put(s,new int[]{source,destination,timestamp});
            List<Integer> list=distMap.getOrDefault(destination,new ArrayList<>());
            list.add(timestamp);
            distMap.put(destination,list);
               return true;

        }

        public int[] forwardPacket() {
            if (queue.isEmpty()) return new int[]{};
            String s=queue.peek();
              queue.poll();
              int[] arr=map.get(s);
              map.remove(s);
              distMap.get(arr[1]).remove(0);
              return arr;
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> list=distMap.get(destination);
           int l=lowerBound(list,startTime);
           int r=upperBound(list,endTime);
           return r-l;
        }

        int lowerBound(List<Integer> list, int start) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid) < start) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l; // index of lower bound
        }

        // upperBound: first index where value > end
        int upperBound(List<Integer> list, int end) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (list.get(mid) <= end) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l; // index of upper bound
        }
    }
}
