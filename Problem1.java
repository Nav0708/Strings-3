//Time Complexity : O(n) where n is the length of the string s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. we iterate through the number based on triplets of thousands (Thousand, Million, Billion).
// 2. For each triplet, we convert it to words using the helper function toWords, which handles numbers less than 1000.
// 3. We build the final string by appending the words for each triplet along with the corresponding thousands place (Thousand, Million, Billion).


class Solution {

    String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String word = "";
        int i=0;
        // Process each group of thousands
        while(num > 0){
            // For each group of thousands, we convert the last three digits to words
            if(num % 1000 != 0)
                // We call the toWords function to convert the last three digits to words
                // and append the corresponding thousands place (Thousand, Million, Billion)
                word = toWords(num % 1000) + thousands[i] + " "+ word;
            // Move to the next group of thousands
            // We divide the number by 1000 to process the next group
          num = num/1000;
          i++;
        }
        return word.trim();
    }
    // Helper function to convert numbers less than 1000 to words
    // It handles numbers in the range of 0 to 999
    public String toWords(int num){
        if(num == 0)
            return "";
        // If the number is less than 20, we return the corresponding word from lessThan20 array
        else if(num < 20){
            return lessThan20[num] + " ";
        }
        else if(num < 100){
            return hundreds[num/10] + " "+toWords(num%10);
        }
        // If the number is 100 or more, we return the corresponding word from lessThan20 array and hundreds array
        else{
            return lessThan20[num/100] + " Hundred "+toWords(num%100);
        }
    }
}