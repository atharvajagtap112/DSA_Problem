package Leetcode_DailyChanllenge;

public class LexicographicallySmallestStringAfterApplyingOperations {
    public String findLexSmallestString(String s, int a, int b) {
         int n=s.length();
          
        //add
        StringBuilder addString=new StringBuilder(s) ;
        for (int i=1;i<n;i+=2){
            int digit=addString.charAt(i)-'0';
            digit=(digit+a)%10;
            addString.setCharAt(i, (char) ((char) digit+'0'));
        }


        String s1=s.substring(n-b);
        String s2=s.substring(0,n-b);

        String rotatedString=s1+s2;
        String left="";
        String  right="";

        if(addString.toString().compareTo(s)<0){
            left=findLexSmallestString(addString.toString(),a,b);

        }
        if (rotatedString.compareTo(s)<0){
         right=findLexSmallestString(addString.toString(),a,b);}

        String minString="";

        if (!left.isEmpty() && !right.isEmpty()){
            minString=left.compareTo(right)<0? left:right;
        }
        else if (!left.isEmpty()&&right.isEmpty()){
           minString=left;
        }
       else if (left.isEmpty()&&!right.isEmpty()){
           minString=right;
        }


        return s.compareTo(minString) <=0? s:findLexSmallestString(minString,a,b);
    }
}
