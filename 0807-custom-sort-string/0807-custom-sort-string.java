class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (countMap.containsKey(c)) {
                int freq = countMap.get(c);
                while (freq-- > 0) {
                    sb.append(c);
                }
                countMap.remove(c); 
            }
        }
        for (char c : countMap.keySet()) {
            int freq = countMap.get(c);
            while (freq-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
