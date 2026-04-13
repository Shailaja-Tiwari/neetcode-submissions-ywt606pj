class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            // Move l to the next alphanumeric character
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            // Move r to the previous alphanumeric character
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            char leftChar = Character.toLowerCase(s.charAt(l));
            char rightChar = Character.toLowerCase(s.charAt(r));

            if (leftChar != rightChar) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}