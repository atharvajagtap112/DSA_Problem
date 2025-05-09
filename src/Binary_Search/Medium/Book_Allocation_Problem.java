package Binary_Search.Medium;

import java.util.*;

public class Book_Allocation_Problem {

        public static int findPages(ArrayList<Integer> arr, int n, int m) {
           if (m>n){
               return -1;
           }
           int low= Collections.max(arr);
           int high = arr.stream().mapToInt(Integer::intValue).sum();
           while (low<=high){
               int mid=(low + high) / 2;
               int students = countStudents(arr, mid);

               if (students > m) {
                   low = mid + 1;
               } else {
                   high = mid - 1;
               }
           }
          return low;

}

    private static int countStudents(ArrayList<Integer> arr, int maxbooks) {
            int student=1;
            int books=0;
            for (int i=0;i<arr.size();i++){
                if (books+arr.get(i)<=maxbooks){
                    books+=arr.get(i);
                }
                else {
                    student++;
                    books=arr.get(i);
                }
            }
            return student;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        System.out.println(findPages(arr,arr.size(),2));
    }
}
