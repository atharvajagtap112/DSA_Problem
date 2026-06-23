package Leetcode_DailyChanllenge;

public class Count_Collisions_on_a_Road {
    public static int countCollisions(String directions) {
        int col=0;
        int right=0;
        int stop=0;
        int n=directions.length();
        for(int i=0;i<n;i++){
            char ch=directions.charAt(i);
            if(ch=='L'&&right>0) {
                col+=right+1;
                right=0;}


            else if(ch=='L'&&(col>0||stop>0)){
                col++;
            }

            else if(ch=='S'){
                if(ch=='S'&&right>0){
                    col+=right;
                    right=0;
                }
                stop++;
            }
            else if(ch=='R') right++;
        }
        return col;
    }

    public static void main(String[] args) {
        System.out.println(countCollisions("LSSSLLSSSSLRRSLLLSLSLRRLLLLLRSSRSRRSLLLSSS"));
    }

}
