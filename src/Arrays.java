public class Arrays {
   public int print2largest(int arr[], int n) {
        int largest=arr[0];
        int secondlargest=-1;
        for (int i=1;i<n;i++){
            if (largest<arr[i]&&largest!=arr[i]){
                int temp=largest;
                largest=arr[i];
                secondlargest=temp;
            } else if (largest>arr[i]&&arr[i]>secondlargest) {
                secondlargest=arr[i];
            }


        }
        return secondlargest;
    }

    public static void main(String[] args) {
        int []arr={1, 2, 0, 3, 2, 4, 5};
        Arrays a=new Arrays();

        System.out.println( a.print2largest(arr,arr.length));
    }
}
