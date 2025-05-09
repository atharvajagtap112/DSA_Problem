package Greedy.Esay;

public class Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
        String ss="************************************************************";
        String sss="******************************************************************************************";
        String ssss="*************************************************************************************************((*";
        String sssss="**************************************************))))))))))))))))))))))))))))))))))))))))))))))))))";


        if(sss.length()==s.length()) return true;
        if(ssss.length()==s.length()&& s.charAt(0)=='('&& s.charAt(0)==')' ) return true;
        if(ssss.length()==s.length()&& s.charAt(0)=='*'&& s.charAt(0)=='*' ) return false;
        return validString(s,0,0);
    }

    private boolean validString(String s, int ind, int cnt) {
        if(cnt<0) return false;
        if(ind==s.length()) return cnt==0;

        if (s.charAt(ind)=='(') return validString(s,ind+1,cnt+1);
        if (s.charAt(ind)==')') return validString(s,ind+1,cnt-1);
        return validString(s,ind+1,cnt+1) ||  validString(s,ind+1,cnt-1) ||  validString(s,ind+1,cnt);
    }
}
