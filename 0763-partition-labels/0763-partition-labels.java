class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        int currStart = 0;
        int currEnd = map.get(s.charAt(0));
        for(int i = 0; i<s.length()-1; i++){
            if(i==currEnd){
                res.add(currEnd-currStart+1);
                currStart = i+1;
                currEnd = map.get(s.charAt(i+1));
            }
            currEnd = Math.max(currEnd, map.get(s.charAt(i)));
        }
        res.add(currEnd-currStart+1);
        return res;
    }
}
// First cut - two pass
// HashMap will give me the last known loc for this char
// currblock will represent from here to end, if anything comes after that