package Heaps;

import java.util.Arrays;

public class Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int count=0;
        while (i<g.length&&j<s.length){
            if (g[i]<=s[j]) {
                i++;
                j++;
                count++;
            }
            else j++;
        }
        return count;
    }
}
