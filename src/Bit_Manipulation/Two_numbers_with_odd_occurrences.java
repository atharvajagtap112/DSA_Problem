package Bit_Manipulation;

public class Two_numbers_with_odd_occurrences {
    public int[] twoOddNum(int Arr[], int N)
    {
        int xor=0;
        for (int i=0;i<N;i++){
            xor=xor^Arr[i];
        }

        int rightmost=((xor&xor-1)^xor);
        int b1=0;
        int b2=0;
        for (int i=0;i<N;i++){
            if ((Arr[i]&rightmost)!=0){
                b1=b1^Arr[i];
            }
            else {
                b2=b2^Arr[i];
            }
        }
        return b1>b2?new int[]{b1,b2} :new int[]{b2,b1};
    }
}
