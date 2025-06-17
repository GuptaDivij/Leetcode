class MyHashSet {
    private boolean[][] hashset;
    public MyHashSet() {
        this.hashset = new boolean[1000][1001];
    }
    
    public void add(int key) {
        this.hashset[key%1000][key/1000] = true;
    }
    
    public void remove(int key) {
        this.hashset[key%1000][key/1000] = false;
    }
    
    public boolean contains(int key) {

        return this.hashset[key%1000][key/1000];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */