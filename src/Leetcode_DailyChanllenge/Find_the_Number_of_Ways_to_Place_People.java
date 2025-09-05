package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.Comparator;

public class Find_the_Number_of_Ways_to_Place_People {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j)continue;


                int topx=points[i][0];
                int topy=points[i][1];
                int bottomx=points[j][0];
                int bottomy=points[j][1];



                if (topx<=bottomx&&bottomy<=topy) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;

                         int pointx=points[k][0];
                         int pointy=points[k][1];
                        if ((bottomx>=pointx&&pointx>=topx)||(bottomy<=pointy&&pointy<=topy))
                                {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) cnt++;
                }
            }
        }
        return cnt;
    }
}
