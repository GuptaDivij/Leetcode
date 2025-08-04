class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length==1) return 1;
        if(fruits.length==2) return 2;
        int max = 2;
        int curr = 2;
        int fruit1 = fruits[0];
        int fruit2 = fruits[1];
        for(int i = 2; i<fruits.length; i++){
            max = Math.max(curr, max);
            if(fruits[i]==fruit1 || fruits[i]==fruit2) curr++;
            else{
                if(fruit1==fruit2){
                    fruit2 = fruits[i];
                    curr++;
                    continue;
                }
                int last = i-1;
                fruit1 = fruits[last];
                fruit2 = fruits[i];
                while(last>=1 && fruits[last]==fruits[last-1]) last--;
                curr = i-last+1;
            }
        }
        return Math.max(curr,max); 
    }
}