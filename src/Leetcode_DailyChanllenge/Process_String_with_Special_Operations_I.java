package Leetcode_DailyChanllenge;

public class Process_String_with_Special_Operations_I {
    public String processStr(String s) {

        StringBuilder str=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetter(ch)){
                str.append(ch);
            }
            else if(ch=='#'){
                str.append(str.toString());
            }
            else if(ch=='%'){
                str.reverse();
            }
            else{
                if(!str.isEmpty())
                 str.deleteCharAt(str.length()-1);
            }
        }
        return str.toString();
    }
}
