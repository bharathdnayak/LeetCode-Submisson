class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder fin = new StringBuilder();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        sb.reverse();

        int j = 0;

        while (j < n) {
            while (j < n && sb.charAt(j) == ' ') {
                j++;
            }

            if (j >= n) break;

            StringBuilder word = new StringBuilder();

            while (j < n && sb.charAt(j) != ' ') {
                word.append(sb.charAt(j));
                j++;
            }

            word.reverse();

            if (fin.length() > 0) {
                fin.append(" ");
            }

            fin.append(word);
        }

        return fin.toString();
    }
}