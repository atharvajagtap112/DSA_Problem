package String_Hard;

public class Count_and_Say {

//    String fun(String str,int n){
//        if (n==1)return str;
//
//        StringBuilder s=new StringBuilder();
//        int i=0;
//        while (i<str.length()){
//            int cnt=0;
//            char ch=str.charAt(i);
//            while (ch==str.charAt(i)){
//                cnt++;
//                i++;    }
//            s.append(String.valueOf(cnt)).append(ch);
//        }
//
//        return fun(s.toString(),n-1);
//    }
//    public String countAndSay(int n) {
//        return fun("1",n);
//    }
    public String countAndSay(int n) {

        if (n==1)return "1";
        String str="1";
        for (int ind=2;ind<=n;ind++){

            StringBuilder s=new StringBuilder();
            int i=0;
            while (i<str.length()){
                int cnt=0;
                char ch=str.charAt(i);
                while (i<str.length()&&ch==str.charAt(i)){
                    cnt++;
                    i++;    }
                s.append(String.valueOf(cnt)).append(ch);
            }

            str= s.toString();
        }
        return str;
    }
}
