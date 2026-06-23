package Leetcode_DailyChanllenge;

public class Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder str=new StringBuilder();
        int n= a.length();
        int m=b.length();
        int i=n-1;
        int j=m-1;
        int pow=0;



        while(i>=0&&j>=0){
            int firstBit= a.charAt(i)-'0';
            int secBit=b.charAt(j)-'0';
            int sum=firstBit+secBit;
            if (sum==2){
                if (pow==0){
                    str.insert(0,'0');
                }else  str.insert(0,'1');

                pow=1;
            }
            else if (sum==0&&pow==1){
                str.insert(0,'1');
                pow=0;
            }
            else if(sum==1&&pow==1){
                str.insert(0,'0');
                pow=1;
            }

            else {
                str.insert(0,String.valueOf(sum));
                pow=0;
            }
            i--;
            j--;
        }

        while (i>=0){
            int sum= a.charAt(i)-'0';
            if (sum==2){
                if (pow==0){
                    str.insert(0,'0');
                }else  str.insert(0,'1');

                pow=1;
            }
            else if (sum==0&&pow==1){
                str.insert(0,'1');
                pow=0;
            }
            else if(sum==1&&pow==1){
                str.insert(0,'0');
                pow=1;
            }

            else {
                str.insert(0,String.valueOf(sum));
                pow=0;
            }
            i--;
        }


        while (j>=0){
            int sum= b.charAt(j)-'0';
            if (sum==2){
                if (pow==0){
                    str.insert(0,'0');
                }else  str.insert(0,'1');

                pow=1;
            }
            else if (sum==0&&pow==1){
                str.insert(0,'1');
                pow=0;
            }
            else if(sum==1&&pow==1){
                str.insert(0,'0');
                pow=1;
            }

            else {
                str.insert(0,String.valueOf(sum));
                pow=0;
            }
            j--;
        }

        if (pow==1){
            str.insert(0,'1');
        }
        return str.toString();
    }
}
