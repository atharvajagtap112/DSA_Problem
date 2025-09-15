package Leetcode_DailyChanllenge;

public class Maximum_Number_of_Words_You_Can_Type {
    public int canBeTypedWords(String text, String brokenLetters) {
     String[] words=text.split(" ");
     char[] letters=brokenLetters.toCharArray();
     int cnt=0;
     for (String word:words){
         for (char letter:letters){
             if (word.indexOf(letter)!=-1){
                 cnt++;
                 break;
             }
         }
     }
     return cnt;
    }
}
