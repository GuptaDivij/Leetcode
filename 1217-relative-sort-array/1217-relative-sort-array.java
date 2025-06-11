class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxElement = Arrays.stream(arr1).max().orElse(0);
        int[] count = new int[maxElement + 1];

        for (int element : arr1) {
            count[element]++;
        }

        int[] result = new int[arr1.length];
        int idx = 0;
        for (int value : arr2) {
            while (count[value] > 0) {
                result[idx++] = value;
                count[value]--;
            }
        }

        for (int num = 0; num <= maxElement; num++) {
            while (count[num] > 0) {
                result[idx++] = num;
                count[num]--;
            }
        }

        return result;
    }
}