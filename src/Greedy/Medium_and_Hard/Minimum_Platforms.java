package Greedy.Medium_and_Hard;

import java.util.Arrays;
import java.util.Map;

public class Minimum_Platforms {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0 ,j=0;
        int cnt=0;
        int maxCnt=0;
        while (i<arr.length){
            if (arr[i]<=dep[j]) {
                cnt++;
                i++;
            }
            else {
                cnt--;
                j++;
            }
            maxCnt= Math.max(maxCnt,cnt);
        }
        return maxCnt;
    }
}
