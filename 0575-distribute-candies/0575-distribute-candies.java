class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> types = new HashSet<>();
        for(int candy: candyType) types.add(candy);
        return Math.min(candyType.length/2, types.size());
    }
}