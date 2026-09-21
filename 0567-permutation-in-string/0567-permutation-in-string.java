class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']--;
            freq[s2.charAt(i) - 'a']++;
        }
        if (isZero(freq)) return true;
        for (int i = n; i < m; i++) {
            freq[s2.charAt(i) - 'a']++;
            freq[s2.charAt(i - n) - 'a']--;
            if (isZero(freq)) return true;
        }
        return false;
    }

    private boolean isZero(int[] freq) {
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
}