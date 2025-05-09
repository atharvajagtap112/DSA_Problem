package Graph.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] vis=new boolean[V];
        Queue<Integer> q= new LinkedList<>();

        q.add(1);

        while (!q.isEmpty()){

            int node=q.poll();
            bfs.add(node);

            for (Integer i :adj.get(node)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
}
