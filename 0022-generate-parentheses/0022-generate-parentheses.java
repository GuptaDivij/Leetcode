class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backTrack(answer, n, 0, 0, new StringBuilder());
        return answer;
    }

    public void backTrack(List<String> ans, int n, int open, int close, StringBuilder curr){
        if(curr.length()==2*n){
            ans.add(curr.toString());
            return;
        }

        if(open<n){
            curr.append("(");
            backTrack(ans, n, open+1, close, curr);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            curr.append(")");
            backTrack(ans, n, open, close+1, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}