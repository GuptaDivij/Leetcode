class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> currRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            for (int j = 0; j < currRow.size(); j++) {
                currRow.set(j, currRow.get(j) + Math.min(nextRow.get(j), nextRow.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
