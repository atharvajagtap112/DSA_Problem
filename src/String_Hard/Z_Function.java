package String_Hard;

public class Z_Function {

    public int [] calculateZ(String s){
        int n=s.length();
        int[] z=new int[n];
        int left=0;
        int right=0;
        for (int k=1;k<n;k++){
            if (right<k){
                left=k;
                right=k;
                while (right<n&&s.charAt(right)==s.charAt(right-left)) right++;

                z[k]=right-left;
                right--;
            }
            else {
                int k1=k-left;
                if (z[k1]<right-k+1){
                    z[k]=z[k1];
                }
                else {
                    left=k;
                    while (right<n&&s.charAt(right)==s.charAt(right-left)) right++;
                    z[k]=right-left;
                    right--;
                }
            }
        }
        return z;
    }
    public int strStr(String haystack, String needle) {
       String s="";
       s+=needle+'$'+haystack;
       int [] z=calculateZ(s);

       for (int i=0;i<z.length;i++){
           if (z[i]==needle.length()) return i;
       }
       return -1;
    }
}
