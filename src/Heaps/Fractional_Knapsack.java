package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fractional_Knapsack {

    class Pair implements Comparable<Pair> {
        int val;
        int weight;

        public Pair(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            // Cast to double before division to avoid integer division
            double ratio1 = (double) this.val / this.weight;
            double ratio2 = (double) o.val / o.weight;

            if (ratio1 < ratio2) return 1;
            if (ratio1 > ratio2) return -1;
            return 0;  // Return 0 for equal ratios
        }
    }

    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < val.size(); i++) {
            list.add(new Pair(val.get(i), wt.get(i)));
        }

        Collections.sort(list);
        double ans = 0;
        int i = 0;

        while (capacity > 0 && i < list.size()) {
            Pair pair = list.get(i);
            if (capacity - pair.weight < 0) {
                ans += ((double) pair.val / (double) pair.weight) * capacity;
            } else {
                ans += pair.val;
            }
            capacity -= pair.weight;
            i++;
        }

        return Math.round(ans * 1000000.0) / 1000000.0;
    }

}
