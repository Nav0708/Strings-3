//Time Complexity : O(n) where n is the length of the string s 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We iterate through the string and build the current number by multiplying the previous number by 10 and adding the new digit.
// 2. When we encounter a non-digit character or reach the end of the string, we perform the calculation based on the last sign encountered.
// 3. We update the result based on the last sign and the current number, and reset the current number for the next iteration.
class Solution {
    public int calculate(String s) {
        //Stack<Integer> stack = new Stack<>();
        char lastsign='+';
        if (s==null) return 0;
        s=s.trim();
        // If the string is empty after trimming, return 0
        if (s.length()==0) return 0;
        int curr=0;
        // calres keeps track of the cumulative result
        // tail keeps track of the last number used in multiplication or division
        int calres=0; 
        int tail=0;
        // Iterate through the string character by character
        for(int i=0; i<s.length();i++){
            // Get the current character
            char c=s.charAt(i);
            // If the character is a digit, update the current number
            if (Character.isDigit(c)){
                curr=curr*10+c-'0';
            }
            // If the character is not a digit, we process the number
            if ((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                // Perform the calculation based on the last sign
                if(lastsign=='+'){
                    calres=calres+curr;
                    // Update the tail to the current number
                    tail=curr;
                }
                // If the last sign was '-', we subtract the current number from the result
                // tail will be the current negative number
                if(lastsign=='-'){
                    calres=calres-curr;
                    tail=-curr;
                }
                // If the last sign was '*', we multiply the tail with the current number
                // and update the result so far
                if(lastsign=='*'){
                    calres=calres-tail +tail*curr;
                    tail=tail*curr;
                }
                if(lastsign=='/'){
                     calres=calres-tail +tail/curr;
                    tail=tail/curr;
                }
                // Reset the current number for the next iteration
                
                curr=0;
                // Update the last sign to the current character
                lastsign=c;

            }
           
        }
         return calres;
    }
}