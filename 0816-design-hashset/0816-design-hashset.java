class MyHashSet {
    private boolean[][] hashset;
    public MyHashSet() {
        this.hashset = new boolean[1000][];
    }
    
    public void add(int key) {
        if(hashset[key%1000]==null && key%1000!=0) hashset[key%1000] = new boolean[1000];
        if(hashset[key%1000]==null && key%1000==0) hashset[key%1000] = new boolean[1001];
        this.hashset[key%1000][key/1000] = true;
    }
    
    public void remove(int key) {
        if(hashset[key%1000]==null) return;
        this.hashset[key%1000][key/1000] = false;
    }
    
    public boolean contains(int key) {
        return hashset[key%1000]==null?false:this.hashset[key%1000][key/1000];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */