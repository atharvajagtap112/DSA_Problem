package Binary_Search.Medium;

import java.util.PriorityQueue;

public class Minimize_Max_Distance_to_Gas_Station_Better {
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            Pair tp = pq.poll();
            int secInd = tp.second;
            howMany[secInd]++;
            double iniDiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = iniDiff / (double) (howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }
        return pq.peek().first;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = minimiseMaxDistance(arr, k);
        System.out.println("The answer is: " + ans);
    }

}