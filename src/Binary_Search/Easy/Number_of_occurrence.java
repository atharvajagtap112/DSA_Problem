package Binary_Search.Easy;

public class Number_of_occurrence {
    static int  count(int[] arr, int n, int x) {
     return BinarySearch(arr,0,arr.length-1,x);
    }

    private static int BinarySearch(int[] arr, int start, int end,int target) {
        int count=0;
        if (start>end){
            return count;
        }
        int mid=start+(end-start)/2;
        if (target==arr[mid]) {
            count++;
        }
        if (target>=arr[mid]){
            count+=BinarySearch(arr,mid+1,end,target);
        }
        if(target<=target) {
           count+=BinarySearch(arr,start,mid-1,target);
        }
        return count;
    }

    public static void main(String[] args) {
        int []arr={1, 1, 2, 2, 2, 2, 3};
        System.out.println(count(arr, arr.length, 4));
    }
}
