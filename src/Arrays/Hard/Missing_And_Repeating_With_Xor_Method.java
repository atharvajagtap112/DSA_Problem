package Arrays.Hard;

public class Missing_And_Repeating_With_Xor_Method {
    int[] findTwoElement(int arr[], int n) {

       int xr=0;
       for (int i=0;i<n;i++){
           xr=xr^arr[i];
           xr=xr^(i+1);
       }
       int number=(xr & ~(xr - 1));//100
       int zero=0;
       int one=0;
       for (int i=0;i<n;i++){
           if ((arr[i]&number)!=0){
               one=one^arr[i];
           }
           else {
               zero=zero^arr[i];
           }
       }
        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }
        int cnt=0;
        for (int i=0;i<n;i++){
            if (zero==arr[i]) cnt++;
            if (cnt==2)  return new int []{zero,one};}
        return new int []{one,zero};
    }
}
