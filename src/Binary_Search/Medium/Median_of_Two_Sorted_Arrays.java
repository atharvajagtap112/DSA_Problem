package Binary_Search.Medium;

public class Median_of_Two_Sorted_Arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0){
            int n2=nums2.length;
            if (n2%2==1) return nums2[n2/2];
            else return (nums2[(n2/2)]+nums2[((n2/2)-1)])/2.0;
        }
        if (nums2.length==0){
            int n1=nums1.length;
            if (n1%2==1) return nums1[n1/2];
            else return (nums1[(n1/2)]+nums1[((n1/2)-1)])/2.0;
        }
        int n1=nums1.length;
        int n2=nums2.length;
        if (n2<n1) return findMedianSortedArrays(nums2,nums1);
        int n=n1+n2;
        int left=(n1+n2+1)/2;
        int low=0;
        int high=n1;
        while (low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;
            if (l1<=r2&&l2<=r1){
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            else if (l1>r2) high=mid1-1;
            else {
                low=mid1+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1={4};
        int []arr2={1,2,3,5,6};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
}
