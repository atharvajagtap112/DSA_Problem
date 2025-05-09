package Adv_Maths;

import java.util.ArrayList;
import java.util.List;

public class All_divisors_of_a_Number {
    public static void print_divisors(int n) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        for (int i=1;i<=Math.sqrt(n);i++){
            if (n%i==0) {
                ans.add(i);
                if (n/i!=i) ans2.add(n/i);
            }
        }
        for (int i=0;i<ans.size();i++){
            System.out.print(ans.get(i));
            System.out.print(" ");
        }
        for (int i=ans2.size()-1;i>=0;i--){
            System.out.print(ans2.get(i));
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        print_divisors(20);
    }
}
