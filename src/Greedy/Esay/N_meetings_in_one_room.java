package Greedy.Esay;

import java.util.Arrays;

public class N_meetings_in_one_room {

    class data implements Comparable<data>{
        int start;
        int end;

        public data(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(data other){
            if (this.end>other.end)  return -1;
            if(this.end< other.end) return 1;
            return 0;
        }
    }
    public int maxMeetings(int start[], int end[]) {
       data[] list=new data[start.length];
       for (int i=0;i<start.length;i++){
           list[i]=new data(start[i],end[i]);
       }
        Arrays.sort(list);
       int cnt=1;
       int freeSpace=list[0].end;
       for (int i=1;i<start.length;i++){
           if (freeSpace<list[i].start){
               cnt++;
               freeSpace=list[i].end;
           }
       }
       return cnt;
    }
}
