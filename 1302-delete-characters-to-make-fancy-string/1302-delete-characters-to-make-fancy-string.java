class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int currCt = 1;
        for(int i = 1; i<sb.length();i++){
            if(sb.charAt(i)==sb.charAt(i-1)) currCt++;
            else currCt = 1;
            if(currCt==3){
                sb.deleteCharAt(i);
                i--;
                currCt--;
            }
        }
        return sb.toString();
    }
}