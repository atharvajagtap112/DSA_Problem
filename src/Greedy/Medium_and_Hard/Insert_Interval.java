package Greedy.Medium_and_Hard;

import java.util.ArrayList;

public class Insert_Interval {





        public int[][] insert(int[][] intervals, int[] newInterval) {
            // If there are no intervals, return the newInterval as the only interval
            if (intervals.length == 0) return new int[][] { { newInterval[0], newInterval[1] } };

            ArrayList<int[]> list = new ArrayList<>();
            int i = 0;
            int n = intervals.length;

            // Add all intervals that come before the newInterval
            while (i < n && intervals[i][1] < newInterval[0]) {
                list.add(new int[] { intervals[i][0], intervals[i][1] });
                i++;
            }

            // Merge overlapping intervals with the newInterval
            int start = newInterval[0];
            int end = newInterval[1];
            while (i < n && intervals[i][0] <= newInterval[1]) {
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
                i++;
            }
            list.add(new int[] { start, end });

            // Add all remaining intervals that come after the newInterval
            while (i < n) {
                list.add(new int[] { intervals[i][0], intervals[i][1] });
                i++;
            }

            // Convert the ArrayList to a 2D array
            int[][] ans = new int[list.size()][2];
            for (int j = 0; j < list.size(); j++) {
                ans[j] = list.get(j);
            }

            return ans;
        }
    }

   
