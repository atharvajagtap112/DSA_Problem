package Arrays.medium;

public class demo {
    public static int reverse(int n){
        int ans=0;
        if (n%10==0){
            n=n/10;
        }
        while (n>0){
            ans=ans*10+n%10;
            n=n/10;
        }
       return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(231));
    }
}
