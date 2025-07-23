class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s.toCharArray(), 0, new ArrayList<>());
        return res;
    }

    public void helper(char[] arr, int idx, List<String> list){
        if (idx == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            if(isPalindrome(arr, idx, i)){
                list.add(new String(arr, idx, i - idx + 1));
                helper(arr, i + 1, list);
                list.remove(list.size() - 1);
            } 
        }
    }
    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left++] != arr[right--]) return false;
        }
        return true;
    }
}