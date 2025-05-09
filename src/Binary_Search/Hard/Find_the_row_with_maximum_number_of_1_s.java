package Binary_Search.Hard;

public class Find_the_row_with_maximum_number_of_1_s {
    public static int rowWithMax1s(int arr[][]) {
      int index=-1;
      int maxOne=0;
      for (int i=0;i<arr.length;i++){
          int noOne=firstOccerence(arr[i]);
          if (noOne>maxOne){
              maxOne=noOne;
              index=i;
          }

      }
      return index;
    }

    private static int firstOccerence(int[] arr) {
        int maxOne=0;
        int n=arr.length;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==1){
                maxOne=n-i;
                break;
            }
        }
        return maxOne;
    }

    public static void main(String[] args) {
        int [][]arr={
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };
        System.out.println(rowWithMax1s(arr));
    }
}
