package DP.Pattern_Dp.Different_Ways_to_Evaluate_a_Boolean_Expression;

public class recurr {

    public int fun(int i,int j,String s,int isTrue){
        if(i>j)return 0;

        if (i==j){
            if (isTrue==1) return s.charAt(i)=='T'?1:0;
            else return s.charAt(i)=='F'?1:0;
        }

        int way=0;
        for (int k=i+1;k<=j-1;k+=2){
            int lt=fun(i,k-1,s,1);
            int lf=fun(i,k-1,s,0);
            int rt=fun(k+1,j,s,1);
            int rf=fun(k+1,j,s,0);

            if (s.charAt(k)=='&'){
                if (isTrue==1){
                    way+= lt*rt;
                }
                else way+= lt*rf+lf*rt+lf*rf;
            }

            else if (s.charAt(k)=='|'){
                if (isTrue==1){
                    way+= lt*rf+lf*rt+lt*rt;
                }
                else way+= lf*rf;
            }

            else {
                if (isTrue==1) way+= lt*rf+lf*rt;
                else way+= lt*rt+rf*lf;
            }
        }
        return way;
    }
    public int countTrue(String s) {
        int n=s.length();
        return fun(0,n-1,s,1);
    }
}
