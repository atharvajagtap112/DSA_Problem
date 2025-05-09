package Binary_Search;

public class Floor_in_a_Sorted_Array {
    static int findFloor(long arr[], int n, long x) {
        int start=0;
        int end=n-1;
        int ans=-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (x==arr[mid]){
                return mid;
            }
            if (arr[mid]>x){
                end=mid-1;
            }
            else {
                ans=mid;
                start=mid+1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr={1,2,8,10,11,12,19};
        System.out.println(findFloor(arr,arr.length,5));
    }
}
