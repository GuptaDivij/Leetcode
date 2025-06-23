class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String [] arr = s.split(" "); // O(s)
        if(arr.length!=pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){ // O(pattern)
            if(!map.containsKey(pattern.charAt(i))){
                if(!map.containsValue(arr[i])) map.put(pattern.charAt(i), arr[i]);
                else return false;
            }
            else if(!map.get(pattern.charAt(i)).equals(arr[i])) return false;
        }
        return true;
    }
}