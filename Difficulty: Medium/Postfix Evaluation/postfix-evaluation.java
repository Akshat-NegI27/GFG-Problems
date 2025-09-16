class Solution {
    public int evaluatePostfix(String[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String token : arr) {
            if (isOperator(token)) {
                int b = st.pop();
                int a = st.pop();
                st.push(applyOp(a, b, token));
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }

    private int applyOp(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return Math.floorDiv(a, b);
            case "^": return (int) Math.pow(a, b);
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
