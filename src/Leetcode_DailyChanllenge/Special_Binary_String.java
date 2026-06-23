package Leetcode_DailyChanllenge;

import java.util.ArrayList;
import java.util.List;

public class Special_Binary_String {
    public String makeLargestSpecial(String s) {
        List<String> list=new ArrayList<>();

        int start=0;
        int sum=0;

        for (int i=0;i<s.length();i++){
            sum+= s.charAt(i)=='1'?1:-1;
            if (sum==0){
                String str= '1' +    makeLargestSpecial(s.substring(start+1,i))+'0';
                list.add( str  );
                start=i+1;
            }
        }
        StringBuilder result=new StringBuilder();
        list.sort((a,b)-> b.compareTo(a) );
        for (String s1:list){
            result.append(s1);

        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println((1<<1)|0 ) ;
    }

    }
