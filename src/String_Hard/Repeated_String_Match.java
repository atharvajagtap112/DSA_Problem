package String_Hard;

public class Repeated_String_Match {
     int PRIME=101;
    public double calculateHash(String s){
        double hash=0;
        for (int i=0;i<s.length();i++){
            hash+=s.charAt(i)*Math.pow(PRIME,i);
        }
        return hash;
    }

    public double updateHash(double prevHash,char oldChar,char newChar,int patternLength){
        double newHash=(prevHash-oldChar)/PRIME;
        newHash+=newChar*Math.pow(PRIME,patternLength-1);
        return newHash;
    }
    public int repeatedStringMatch(String a, String b) {
        int patternLength=a.length();
        int n=b.length();

       double aHash=calculateHash(a);
       double bHash=calculateHash(b.substring(0,patternLength));

       int cnt=0;
       for (int i=0;i<=n-patternLength;i++){
           if (aHash==bHash) cnt++;
           if (i+patternLength<n){
               bHash=updateHash(bHash,b.charAt(i),b.charAt(i+patternLength),patternLength);
           }
       }
       return cnt!=0?cnt:-1;
    }
}
