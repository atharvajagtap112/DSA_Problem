package Leetcode_DailyChanllenge;

public class Find_the_Minimum_Amount_of_Time_to_Brew_Potions {

    public long minTime(int[] skill, int[] mana) {
     int n= skill.length;
     int m= mana.length;

     long[] ans=new long[n];
     ans[0]=skill[0]*mana[0];
     for (int i=1;i<n;i++){
         ans[i]= ans[i - 1] + (skill[i] * 1L * mana[i]);
     }

     for (int i=1;i<m;i++){
         long low=ans[0]+1;
         long high=ans[n-1];
         long time=0;
         while (low<=high){
             long mid=(low+high)/2;

          boolean flag=    startTime(mid,ans,mana[i],skill);
             if (flag){
                 high=mid-1;
                 time=mid;
             }
             else low=mid+1;
         }

         ans[0]=time;
         for (int j=1;j<n;j++){
             ans[j]=ans[j-1]+(skill[j]*1L*mana[i]);
         }
     }
    return ans[n-1];
    }


    private boolean startTime(long s, long[] ans, int potion, int[] skill) {
        int n=skill.length;
        long time=s;

        for (int i=0;i<n;i++){
            if (time<ans[i]) return false;
            time=time+(skill[i]*1L*potion);
        }
        return true;
    }
}
