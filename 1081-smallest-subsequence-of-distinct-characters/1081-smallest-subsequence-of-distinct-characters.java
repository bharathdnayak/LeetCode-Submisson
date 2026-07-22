class Solution {
    public String smallestSubsequence(String s) {

        int n = s.length();

        int[] last = new int[26];

        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();
        boolean[] present = new boolean[26];

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (present[ch - 'a'])
                continue;

            while (!st.isEmpty() &&
                   st.peek() > ch &&
                   last[st.peek() - 'a'] > i) {

                present[st.pop() - 'a'] = false;
            }

            st.push(ch);
            present[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}