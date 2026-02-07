class LFUCache {
    private int capacity;
    private int minFreq;

    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        if (keyToVal.size() == capacity) {
            LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
            int evictKey = keys.iterator().next();
            keys.remove(evictKey);

            if (keys.isEmpty()) {
                freqToKeys.remove(minFreq);
            }

            keyToVal.remove(evictKey);
            keyToFreq.remove(evictKey);
        }

        // insert new key
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        LinkedHashSet<Integer> keys = freqToKeys.get(freq);
        keys.remove(key);

        if (keys.isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }
}
