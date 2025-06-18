class MyHashMap {

    private int[][] hashmap;
    
    public MyHashMap() {
        this.hashmap = new int[1000][];
    }
    
    public void put(int key, int value) {
        if (hashmap[key%1000] == null) {
            hashmap[key%1000] = (key%1000 == 0) ? new int[1001] : new int[1000];
            Arrays.fill(hashmap[key%1000], -1);
        }
        hashmap[key%1000][key/1000] = value;
    }
    
    public int get(int key) {
        return hashmap[key%1000]==null?-1:hashmap[key%1000][key/1000];
    }
    
    public void remove(int key) {
        if(hashmap[key%1000]==null) return;
        hashmap[key%1000][key/1000] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */