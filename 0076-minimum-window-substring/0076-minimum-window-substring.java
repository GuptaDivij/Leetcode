class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int [] sWindow = new int[52];
        int [] tWindow = new int[52];

        for(int i = 0; i<t.length();i++){
            char c = t.charAt(i);
            tWindow[Character.isLowerCase(c)?c-'a':c-'A'+26]++;
        }

        int start = 0;
        int [] best = new int[2];
        best[0]=-1;
        for(int end = 0; end<s.length(); end++){
            char c = s.charAt(end);
            sWindow[Character.isLowerCase(c)?c-'a':c-'A'+26]++;
            while(contains(sWindow, tWindow)){
                if(best[0]==-1 || (best[1]-best[0]) > (end-start)){
                    best[0]=start;
                    best[1]=end;
                }
                c = s.charAt(start++);
                sWindow[Character.isLowerCase(c)?c-'a':c-'A'+26]--;
            }
        }
        return best[0]==-1?"":s.substring(best[0], best[1]+1);
    }
    public boolean contains(int[]s,int[]t){
        for(int i = 0; i<52; i++){
            if(t[i]>s[i]) return false;
        }
        return true;
    }
}