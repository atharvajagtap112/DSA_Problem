package revesion;

import java.util.Arrays;
import java.util.Comparator;
class process {
    int at;
    int cp;

    public process(int at, int cp) {
        this.at = at;
        this.cp = cp;
    }


}
public class scheduling {


    public static void main(String[] args) {
        process[] p=new process[3];



        p[0]=new process(1,5);
        p[1]=new process(0,3);
        p[2]=new process(2,2);

        Arrays.sort(p,(a,b)->Integer.compare(a.at,b.at));

         int Wt=0;
         int AWt=0;
         int ATAT=0;
        for (process ele:p){
            System.out.println("Waiting time "+Wt);
            AWt+=Wt;
            System.out.println("T Time "+(Wt+ele.cp));
            ATAT+=Wt+ele.cp;
            Wt+=ele.cp;
        }

        System.out.println(( (double) AWt/3));
        System.out.println((double) ATAT/3);
    }
}
