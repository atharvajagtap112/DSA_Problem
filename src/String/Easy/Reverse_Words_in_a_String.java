package String.Easy;

public class Reverse_Words_in_a_String {
    public static String reverseWords(String s) {
    String ans="";
    int i=0;
    while(i<s.length()) {
        String temp = "";
        while (i<s.length()&&s.charAt(i) == ' ') {
            i++;
        }
        while (i<s.length()&&s.charAt(i) != ' ') {
         temp+=s.charAt(i);
         i++;
        }
        if (temp.length()!=0){
        if (ans.length()==0){
            ans+=temp;
            temp="";
        }
        else {
            ans=temp+" "+ans;
        }}
    }
return ans;
    }

    public static void main(String[] args) {
        String s="  the sky is     blue  ";
        System.out.println(reverseWords(s));
    }
}
