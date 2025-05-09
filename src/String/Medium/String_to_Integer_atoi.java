package String.Medium;

public class String_to_Integer_atoi {
    public static int myAtoi(String s) {
       int i=0; int sign=-1;
       for (;(i<s.length())&&s.charAt(i)==' ';i++)

        if (s.charAt(i)=='-') sign=-1;
       int num=0;
       for (;i<s.length()&&Character.isDigit(s.charAt(i))&&num<=Integer.MAX_VALUE;i++){
            num+=num*10+s.charAt(i)-'0';
       }
        num = Math.max(sign * num, Integer.MIN_VALUE);
        num = Math.min(num, Integer.MAX_VALUE);
        return (int) num;
    }

    public static void main(String[] args) {
      String  s="-+12";
        System.out.println(myAtoi(s));

    }
}
