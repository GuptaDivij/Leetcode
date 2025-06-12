class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        ArrayList<Pair<Integer, String>> currList = map.get(key);
        if(currList.get(0).getKey() > timestamp) return "";

        int low = 0, high = currList.size() - 1;
        String result = "";
        while (low <= high) {
            int mid = (low + high) / 2;
            if (currList.get(mid).getKey() <= timestamp) {
                result = currList.get(mid).getValue(); 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */