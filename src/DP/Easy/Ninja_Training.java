package DP.Easy;

import java.util.Arrays;

public class Ninja_Training {

    static int fun1(int day,int last,int [][]points){
        if(day==0){
            int maxi=Integer.MIN_VALUE;
            for (int i=0;i<3;i++){
                if(last!=i){
                    maxi=Math.max(maxi,points[day][i]);
                }
            }
            return maxi;
        }

        int maxi=Integer.MIN_VALUE;
        for (int i=0;i<3;i++){
            if(last!=i){
                int point=points[day][i]+fun1(day-1,i,points);
                maxi=Math.max(maxi,point);
            }
        }
        return maxi;
    }

    static int fun2(int day,int last,int [][]points,int [][]dp){
        if(day==0){
            int maxi=Integer.MIN_VALUE;
            for (int i=0;i<3;i++){
                if(last!=i){
                    maxi=Math.max(maxi,points[day][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last]!=-1) return dp[day][last];

        int maxi=Integer.MIN_VALUE;
        for (int i=0;i<3;i++){
            if(last!=i){
                int point=points[day][i]+fun2(day-1,i,points,dp);
                maxi=Math.max(maxi,point);
            }
        }
        return dp[day][last]= maxi;
    }
    public static int ninjaTraining1(int n, int points[][]) {
        int[][] dp=new int[n][4];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun2(n-1,3,points,dp);

    }

    static int ninjaTraining2(int n, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[n][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }

    static int ninjaTraining(int n, int[][] points) {
        // Initialize an array 'prev' to store the maximum points for the previous day
        int prev[] = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day starting from the second day
        for (int day = 1; day < n; day++) {
            // Initialize an array 'temp' to store the maximum points for the current day
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            // Update 'prev' to store the maximum points for the current day
            prev = temp;
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return prev[3];
    }
}
