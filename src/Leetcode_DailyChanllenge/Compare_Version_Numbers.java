package Leetcode_DailyChanllenge;

public class Compare_Version_Numbers {

    public int fun(String str){
        int ans=0;

            int i=0;
            while (i<str.length()&&str.charAt(i)=='0') i++;

            if (i<str.length()){
                String sub=str.substring(i);
                ans= (int) (ans*Math.pow(10,sub.length())+Integer.parseInt(sub)); }


        return ans;
    }

    public int compareVersion(String version1, String version2) {
        String [] arr1=version1.split("\\.");
        String [] arr2=version2.split("\\.");
        int v1=0;int v2=0;
        int i=0; int j=0;
        int n=arr1.length;  int m=arr2.length;

        while (i<n&&j<m){
            int a=fun(arr1[i]);
            int b=fun(arr2[j]);
            if (a!=b){
                v1=a; v2=b;
                break;
            }
            i++; j++;
        }

        if (v1==0&&v2==0) {
            while (i < n) {
                int a = fun(arr1[i]);
                if (a != 0) {
                    v1 = a;
                    break;
                }
                i++;
            }

            while (j < m) {
                int b = fun(arr1[j]);
                if (b != 0) {
                    v2 = b;
                    break;
                }
                j++;
            }
        }
        if (v1==v2)return 0;
        return v1>v2?1:-1;
    }

    public static void main(String[] args) {

    }
}
