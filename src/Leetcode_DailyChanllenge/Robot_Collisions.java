package Leetcode_DailyChanllenge;

import java.util.*;

public class Robot_Collisions {
    class Robo {
        int p;
         char d;
        int h;
        int idx;

        public Robo(int p, char d, int h, int idx) {
            this.p = p;
            this.d = d;
            this.h = h;
            this.idx = idx;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
         int n=positions.length;
        List<Robo> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(new Robo(positions[i], directions.charAt(i),healths[i],i));
        }

        Collections.sort(list, Comparator.comparingInt(a -> a.p));

        Stack<Robo> stack=new Stack<>();

        for (Robo currRobo:list){


            boolean isDistory=false;
            while(!stack.isEmpty()&stack.peek().d=='R'&&currRobo.d=='L'){
                if(!stack.isEmpty()&& stack.peek().h==currRobo.h ){
                    stack.pop();
                    isDistory=true;
                    break;
                }
                else if (!stack.isEmpty()&& stack.peek().h>currRobo.h){
                    stack.peek().h--;
                    isDistory=true;
                    break;
                }
                else {
                    stack.pop();
                    currRobo.h--;
                }
            }

            if (!isDistory){
                stack.push(currRobo);
            }

        }

        List<Robo> result=new ArrayList<>();
        while (!stack.isEmpty()){
             result.add(stack.pop());
        }

        Collections.sort(result,(a,b)->Integer.compare(a.idx, b.idx));

        return result.stream().map(a->a.h).toList();

    }
}
