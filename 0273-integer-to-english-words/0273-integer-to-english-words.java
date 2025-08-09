class Solution {
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};
    String[] below20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            int triplet = num % 1000;
            if (triplet > 0) {
                String curr = "";
                if (triplet < 20) curr = curr + below20[triplet];
                else if (triplet < 100) curr = curr + tens[triplet/10] + " " + below20[triplet%10];
                else {
                    curr = curr + below20[triplet/100] + " Hundred ";
                    if(triplet%100 < 20) curr = curr + below20[triplet%100]; 
                    else curr = curr + tens[(triplet%100)/10] + " " + below20[triplet%10];
                }
                res.insert(0, curr.trim() + thousands[i]);
            }
            num = num / 1000;
            i++;
        }
        return res.toString().trim();
    }
}
