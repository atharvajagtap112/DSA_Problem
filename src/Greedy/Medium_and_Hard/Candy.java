package Greedy.Medium_and_Hard;

public class Candy {
    public int candy(int[] ratings) {
      int n=ratings.length;
        int i=1;
      int sum=1;
      while (i<n){
          if(ratings[i]==ratings[i-1]) {
              sum++;
              continue;
          }
          int peak=1;
          while (i<n&&ratings[i]>ratings[i-1]){
              i++;
              peak++;
              sum+=peak;
          }

          int down=1;
          while (i<n&&ratings[i]<ratings[i+1]){
              i++;
              down++;
              sum+=down;

          }

          if (peak<down){
              sum+=down-peak;
          }
      }
return sum;
    }
}
