package Binary_Search.Medium;

public class Find_Nth_root_of_M {
    public static int NthRoot(int n, int m){
       int low=1;
       int high=m;
       while (low<=high){
           long mid=low+(high-low)/2;
           double sq= square(mid,n);
           if (sq==m){
               return (int) mid;
           }
           if (sq<m){
               low=(int)mid+1;
           }
           else {
               high=(int)mid-1;
           }
       }
       return -1;
    }

    private static double square(long num,int n) {
        double ans=1;
        for (int i=1;i<=n;i++){
            ans=ans*num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(7,4096));
    }
}
