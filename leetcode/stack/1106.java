class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c: expression.toCharArray()) {
            if (c == '&' || c == '|' || c == '!' || c == 't' || c == 'f') {
                stack.push(c);
            } else if (c == ')') {
                char curr = stack.pop();
                boolean and = true;
                boolean or = false;
                boolean not = true;
                while (!stack.isEmpty() && (curr == 't' || curr == 'f')) {
                    and = and && (curr == 't' ? true : false);
                    or = or || (curr == 't' ? true : false);
                    not = curr == 't' ? false : true;
                    curr = stack.pop(); 
                }

                switch (curr) {
                    case '&':
                        stack.push(and ? 't' : 'f'); break;
                    case '|':
                        stack.push(or ? 't' : 'f'); break;
                    case '!':
                        stack.push(not ? 't' : 'f'); break;
                    default:
                        stack.push(curr);
                }
            }
        }
        return stack.pop() == 't' ? true : false;
    }
}