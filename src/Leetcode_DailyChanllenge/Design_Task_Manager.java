package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Design_Task_Manager {

    class TaskManager {

        class pair{
            int task;
            int priority;

            public pair(int task, int priority) {
                this.task = task;
                this.priority = priority;
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> userMap=new HashMap<>();
        PriorityQueue<pair> pq=new PriorityQueue<>(
                (a,b)->{
                    if (a.priority!=b.priority) return Integer.compare(b.priority,a.priority);
                    else return Integer.compare(b.task,a.task);
        }
        );

        public TaskManager(List<List<Integer>> tasks) {
          for (List<Integer> ele:tasks){
              map.put(ele.get(1),ele.get(2));
              map.put(ele.get(1),ele.get(0));
              pq.add(new pair(ele.get(1),ele.get(2)));
          }
        }

        public void add(int userId, int taskId, int priority) {
             map.put(taskId,priority);
             userMap.put(taskId,userId);
             pq.add(new pair(taskId,priority));
        }

        public void edit(int taskId, int newPriority) {
            map.put(taskId,newPriority);
            pq.add(new pair(taskId,newPriority));
        }

        public void rmv(int taskId) {
          map.remove(taskId);
          userMap.remove(taskId);
        }

        public int execTop() {
            while (!pq.isEmpty()){
                if (pq.peek().priority==map.get(pq.peek().task)){
                    return userMap.get(pq.peek().task);
                }
                else pq.poll();
            }
            return -1;
        }
    }
}
