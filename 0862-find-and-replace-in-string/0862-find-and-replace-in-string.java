class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<indices.length;i++){
            if(s.startsWith(sources[i], indices[i])){
                map.put(indices[i], i);
            }
        }
        for(int i = 0; i<s.length(); i++){
            if(map.containsKey(i)){
                int index = map.get(i);
                String source = sources[index];
                String target = targets[index];
                sb.append(target);
                i += source.length() - 1;
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}