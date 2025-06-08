public class Arrays {
    Arrays(){

    }
    Arrays(int a,int b){

    }

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
      demo1 d=new demo1(4);
//       demo1 dd=new demo1(8);
//        System.out.println(d.a);
//
//        System.out.println(d.demo1());
    }


}

 class demo1{
    static int a=10;
   static {
       System.out.println("wddsfdsfds");
   }

    demo1(int a){
        this.a=a;
    }
   public int demo1(){
        return 45;
    }
  public demo1 m1(){
        return this;
  }


 }

 interface vehical{
    int a=101;
  
 }