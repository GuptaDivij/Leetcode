class RandomizedSet {
    HashSet<Integer> set;
    ArrayList<Integer> list;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }
        list.add(val);
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)){
            return false;
        }
        set.remove(val);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i)==val){
                list.remove(i);
                break;
            }
        }
        return true;
    }
    
    public int getRandom() {
        int size = set.size();
        Random rand = new Random();
        int random = rand.nextInt(0, size);
        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */