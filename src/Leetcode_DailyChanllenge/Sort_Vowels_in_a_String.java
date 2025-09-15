package Leetcode_DailyChanllenge;

import java.util.Arrays;

public class Sort_Vowels_in_a_String {
    public String sortVowels(String s) {
        int[] upCase=new int[26];
        int[] loCase=new int[26];

        char[] arr= s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                arr[i]=' ';
                upCase[ch-'A']++;
            }
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                arr[i]=' ';
                loCase[ch-'a']++;
            }
        }

        int i=0;
        int j=0;
        while (i<arr.length&&j<26){
            if(arr[i]!=' '){
                i++;
                continue;
            }

            while (j<26&&upCase[j]==0){
                j++;
            }

            if(j>=26) break;
            arr[i]=(char)  ('A'+j);
            upCase[j]--;
            i++;
        }

        j=0;
        while (i<arr.length&&j<26){
            if(arr[i]!=' '){
                i++;
                continue;
            }
            while (j<26&&loCase[j]==0){
                j++;
            }
            if(j>=26) break;
            arr[i]=(char)  ('a'+j);
            loCase[j]--;
            i++;
        }

        return new String(arr);
    }
}
