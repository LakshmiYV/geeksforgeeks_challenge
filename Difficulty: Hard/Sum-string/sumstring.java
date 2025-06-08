class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        // Try every pair of first and second number
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String num1 = s.substring(0, i);
                String num2 = s.substring(i, j);
                
                // Skip if num1 or num2 have leading zeros (invalid)
                if ((num1.length() > 1 && num1.charAt(0) == '0') ||
                    (num2.length() > 1 && num2.charAt(0) == '0')) {
                    continue;
                }
                
                if (isValid(s.substring(j), num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Helper function to validate the sum-string from current index
    private boolean isValid(String remaining, String num1, String num2) {
        String sum = addStrings(num1, num2);
        
        // If remaining doesn't start with sum, return false
        if (!remaining.startsWith(sum)) {
            return false;
        }
        
        // If exact match, it's a valid sum-string
        if (remaining.equals(sum)) {
            return true;
        }
        
        // Recursively check the rest
        return isValid(remaining.substring(sum.length()), num2, sum);
    }

    // Helper function to add two big integers represented as strings
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        
        return sb.reverse().toString();
    }
}
