package Arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternateNumbers {

        public static int[] alternateNumbers(int[] a){
            ArrayList<Integer> positive=new ArrayList<>();
            ArrayList<Integer> negative=new ArrayList<>();
            for (int i=0;i< a.length;i++){
                if (a[i]>0){
                    positive.add(a[i]);
                }
                else {
                    negative.add(a[i]);
                }
            }

            if (positive.size()>negative.size()){
                for (int i=0;i<negative.size();i++){
                    a[i*2]=positive.get(0);
                    a[i*2+1]=negative.get(0);
                }
                int index=negative.size()*2;
                for (int j=negative.size();j<positive.size();j++){
                    a[index]=positive.get(j);
                    index++;
                }
            }
            else {
                for (int i=0;i<positive.size();i++){
                    a[i*2]=positive.get(0);
                    a[i*2+1]=negative.get(0);
                }
                int index=positive.size()*2;
                for (int j=positive.size();j<negative.size();j++){
                    a[index]=negative.get(j);
                    index++;
                }
            }
            return a;

}

    public static void main(String[] args) {
        int []arr={1,2,-3,-1,-2,3};
        System.out.println(Arrays.toString(alternateNumbers(arr)));
    }}
