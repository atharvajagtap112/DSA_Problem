package String.Easy;

public class Rotate_String {
    public static boolean rotateString(String s, String goal) {

    String first="", second="";

    for (int i=0;i<goal.length();i++){

        if (s.charAt(0)==goal.charAt(i)&&(goal.substring(i)+second).equals(s)) return true;
        second+=goal.charAt(i);
    }
    return false;
    }

    public static void main(String[] args) {
        String a="bbbacddceeb";
        String b="ceebbbbacdd";
        System.out.println(rotateString(a,b));
    }
}
