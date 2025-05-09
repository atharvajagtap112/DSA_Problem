package Graph.Topological_sort_and_problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for (int i=0;i<numCourses;i++) list.add(new ArrayList<>());

        for (int[] course:prerequisites) list.get(course[1]).add(course[0]);

        int[] degree=new int[numCourses];
        for (int [] course:prerequisites){
            degree[course[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int a:degree){
            if (a==0) q.add(a);
        }

        int count=-0;
        while (!q.isEmpty()){
            int node=q.poll();
            count++;

            for (int n:list.get(node)){
                degree[n]++;
                if (degree[n]==0){
                    q.add(n);
                }
            }
        }

        return count==numCourses;
    }
}
