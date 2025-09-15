package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Vowel_Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {

        int n= wordlist.length;
        int m= queries.length;
        String[] arr=new String[m];
        Arrays.fill(arr,"");
        Set<String>set=new HashSet<>(Arrays.stream(wordlist).toList());
        HashMap<String,String> lcMap=new HashMap();
        HashMap<String,String> vMap=new HashMap();
        for (int i=0;i<n;i++){
            set.add(wordlist[i]);

            String str=wordlist[i].toLowerCase();
            if(!lcMap.containsKey(str)){
                lcMap.put(str,wordlist[i]);}

            StringBuilder s= new StringBuilder();
            for (char ch:str.toCharArray()){
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    s.append('*');
                }
                else s.append(ch);
            }

            if(!vMap.containsKey(s.toString())){
                vMap.put(s.toString(),wordlist[i]);}
        }



        for (int i=0;i<m;i++){
            String queri=queries[i];
            if (set.contains(queri)){
                arr[i]=queri;
            }
            else if(lcMap.containsKey(queri.toLowerCase())){
                arr[i]=lcMap.get(queri.toLowerCase());
            }
            else {
                StringBuilder s= new StringBuilder();
                for (char ch:queri.toLowerCase().toCharArray()){
                    if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                        s.append('*');
                    }
                    else s.append(ch);
                }

                if (vMap.containsKey(s.toString())){
                    arr[i]=vMap.get(s.toString());
                }
            }
        }



        return arr;
    }
}
