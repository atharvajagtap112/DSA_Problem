package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Minimum_Pair_Removal_to_Sort_Array_II {
    class pair{
        int sum;
        int idx;

        public pair(int idx, int sumn) {
            this.sum = sum;
            this.idx = idx;
        }
    }
    public int minimumPairRemoval(int[] nums) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.sum == b.sum) return Integer.compare(a.idx, b.idx);
            return Integer.compare(a.sum, b.sum);
        });
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] prevIdx = new int[n + 1];
        int[] nextIdx = new int[n + 1];


        nextIdx[n - 1] = n;
        int badPair = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) badPair++;
            prevIdx[i] = i - 1;
            nextIdx[i] = i + 1;
            map.put(i, nums[i] + nums[i + 1]);
            pq.add(new pair(i, nums[i] + nums[i + 1]));
        }
        int opr = 0;

        while (badPair != 0) {
            pair p = pq.poll();
            int sum = p.sum;
            int first = p.idx;
            int second = nextIdx[first];
            int firstLeft = prevIdx[first];
            int secondRight = nextIdx[second];

            if (map.get(first) != sum) continue;

            if (nums[first] > nums[second]) badPair--;

            if (nums[firstLeft] > nums[first] && nums[firstLeft] <= sum) {
                badPair--;
            }
            if (nums[firstLeft] <= nums[first] && nums[firstLeft] > sum) {
                badPair++;
            }

            if (nums[secondRight] < nums[second] && nums[secondRight] >= sum) {
                badPair--;
            }
            if (nums[secondRight] >= nums[second] && nums[secondRight] < sum) {
                badPair++;
            }


            pq.add(new pair(firstLeft, nums[firstLeft] + sum));
            map.put(firstLeft, nums[firstLeft] + sum);
            pq.add(new pair(first, nums[secondRight] + sum));
            map.put(first, nums[secondRight] + sum);

            prevIdx[secondRight] = first;
            nextIdx[first] = secondRight;

            opr++;


        }

        return opr;
    }
}
