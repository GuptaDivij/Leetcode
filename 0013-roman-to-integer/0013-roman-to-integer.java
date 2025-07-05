class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('I', 1);
        scoreMap.put('V', 5);
        scoreMap.put('X', 10);
        scoreMap.put('L', 50);
        scoreMap.put('C', 100);
        scoreMap.put('D', 500);
        scoreMap.put('M', 1000);

        int ans = 0;
        for(int i = 0; i<s.length();i++){
            if(i+1<s.length() && scoreMap.get(s.charAt(i)) < scoreMap.get(s.charAt(i+1))){
                ans-=scoreMap.get(s.charAt(i));
            }
            else ans+=scoreMap.get(s.charAt(i));
        }
        return ans;
    }
}