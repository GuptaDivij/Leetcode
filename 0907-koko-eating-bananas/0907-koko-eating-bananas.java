class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while(low<high){
            int k = (low+high)/2;
            int hours = 0;
            for (int pile : piles) {
                if(pile%k==0) hours+= pile/k;
                else hours += (pile+(k-pile%k))/k;
                if(hours>h) break;
            }
            if (hours <= h) high = k;
            else low = k+1;
        }
        return low;
    }
}