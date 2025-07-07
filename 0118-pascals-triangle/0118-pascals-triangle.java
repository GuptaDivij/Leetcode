class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for(int i = 1; i<numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prevRow = res.get(res.size()-1);
            for(int j = 1; j<i; j++){
                temp.add(prevRow.get(j-1) + prevRow.get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}