package String.Medium;

public class Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
    String LPS="";
    for (int i=1;i<s.length();i++){
        int low=i;
        int high=i;

        while (s.charAt(low)==s.charAt(high)){
            low--;
            high++;
            if (low==-1||high==s.length()) break;
        }
        String palindrome=s.substring(low+1,high);
        if (LPS.length()<palindrome.length()) LPS=palindrome;

        low=i-1;
        high=i;
        while (s.charAt(low)==s.charAt(high)){
            low--;
            high++;
            if (low==-1||high==s.length()) break;
        }
        palindrome=s.substring(low+1,high);
        if (LPS.length()<palindrome.length()) LPS=palindrome;
    }
    return LPS;
    }

    public static void main(String[] args) {
        String a="bacabab";
        System.out.println(longestPalindrome(a));
    }
}
