class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String c = tokens[i];

            if (!c.equals("+") &&
                !c.equals("-") &&
                !c.equals("*") &&
                !c.equals("/")) {

                st.push(Integer.parseInt(c));

            } else {

                int b = st.pop();
                int a = st.pop();

                if (c.equals("+")) {
                    st.push(a + b);

                } else if (c.equals("-")) {
                    st.push(a - b);

                } else if (c.equals("/")) {
                    st.push(a / b);

                } else if (c.equals("*")) {
                    st.push(a * b);
                }
            }
        }

        return st.pop();
    }
}