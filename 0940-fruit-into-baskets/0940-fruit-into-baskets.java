class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n <= 2) return n;
        int max = 2, curr = 2;
        int fruit1 = fruits[0];
        int fruit2 = fruits[1];

        // Track the last index of a streak of the same fruit
        int lastStreakStart = (fruit1 == fruit2) ? 0 : 1;  

        for (int i = 2; i < n; i++) {
            if (fruits[i] == fruit1 || fruits[i] == fruit2) {
                curr++;
                if (fruits[i] != fruits[i - 1]) {
                    lastStreakStart = i; // start of the new streak
                }
            } else {
                max = Math.max(max, curr);
                // Shift window: keep the last streak + new fruit
                curr = i - lastStreakStart + 1;
                fruit1 = fruits[lastStreakStart];
                fruit2 = fruits[i];
                lastStreakStart = i;
            }
        }

        return Math.max(max, curr);
    }
}
