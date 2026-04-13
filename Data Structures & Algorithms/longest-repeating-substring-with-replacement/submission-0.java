class Solution {
    public int characterReplacement(String s, int k) {
    java.util.Map<Character, Integer> charCount = 
        new java.util.HashMap<>();
    int left = 0;
    int maxFreq = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        char rightChar = s.charAt(right);
        charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
        maxFreq = Math.max(maxFreq, charCount.get(rightChar));

        int windowSize = right - left + 1;
        if (windowSize - maxFreq > k) {
            char leftChar = s.charAt(left);
            charCount.put(leftChar, charCount.get(leftChar) - 1);
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}
    }

