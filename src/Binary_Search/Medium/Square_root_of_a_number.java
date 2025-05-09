package Binary_Search.Medium;

public class Square_root_of_a_number {
    static long floorSqrt(long x)
    {
     int low=1;
     int high=(int)x;

     while (low<=high){
         long mid=low+(high-low)/2;
         if ((mid*mid)<=x){

             low= (int) (mid+1);
         }
         else {
             high=(int)mid-1;
         }
     }
     return high;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(5));
    }
}
