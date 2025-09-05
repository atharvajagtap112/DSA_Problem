package String_Hard;

public class Count_Palindromic_Subsequences {


    public int rev(int x){
        if (x<10) {
            return x*10;
        }
        return 10*(x%10)+x/10;
    }
    public int countPalindromes(String s) {
       int[] forwardCount=new int[10];
       int[] backwardCount=new int[10];
       int[] subFront=new int[100];
       int[] subback=new int[100];
       int n=s.length();

       int ans=0;

       for (int i=n-1;i>=0;i--){
           int x=s.charAt(i)-'0';
           for (int j=0;j<10;j++){
               subback[x*10+j]+=backwardCount[j];
           }
       }

       for (int i=0;i<n;i++){
           int x=s.charAt(i)-'0';
           backwardCount[x]--;
           for (int j=0;j<10;j++){
               subback[x*10+j]--;
           }
           for(int j=0;j<100;j++){
               if (subFront[j]>0){
                   int revV=rev(j);
                   if (subback[revV]>0){
                       ans+=1;
                   }
               }

               forwardCount[x]++;
               for (int k=0;k<10;k++){
                   subFront[rev(x*10+k)]+=forwardCount[k];
               }
           }
       }
       return ans;
    }
}
