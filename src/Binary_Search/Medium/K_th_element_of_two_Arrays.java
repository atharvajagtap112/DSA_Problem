package Binary_Search.Medium;

public class K_th_element_of_two_Arrays {
    public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
   if (m<n){
       return kthElement(arr2,arr1,m,n,k);
   }
        int low=Math.max(0,k-arr2.length);
        int high=Math.min(arr1.length,k);
        while (low<=high){
            int mid1=(low+high)/2;
            int mid2=Math.abs(k-mid1);
            int r1=(mid1<n)? arr1[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<m)? arr2[mid2]:Integer.MAX_VALUE;
            int l1=(mid1>0)? arr1[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2>0)? arr2[mid2-1]:Integer.MAX_VALUE;
            if (l1<=r2&&l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                high=mid1-1;
            }
            else {
                low=mid1+1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int []arr2={100};
        int []arr1={72, 86, 113, 119, 265, 445, 892};
        System.out.println(kthElement(arr1,arr2,arr1.length,arr2.length,7));
    }
}
