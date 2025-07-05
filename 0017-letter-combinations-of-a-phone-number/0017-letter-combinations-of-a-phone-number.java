class Solution {
    private HashMap<Character, String> map = new HashMap<>();
    private List<String> ans = new ArrayList<>();
    private String digits;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4',"ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7',"pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        this.digits = digits;
        helper(0, new StringBuilder());
        return ans;
    }

    public void helper(int currPointer, StringBuilder path){
        if(digits.length() == path.length()){
            ans.add(path.toString());
            return;
        }
        String curr = map.get(digits.charAt(currPointer));
        for(int i = 0; i<curr.length(); i++){
            path.append(curr.charAt(i));
            helper(currPointer+1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}