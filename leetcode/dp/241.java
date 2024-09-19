class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        parseExpression(expression, nums, operators);

        List<Integer> results = new ArrayList<>();

        return results;
    }

    private void parseExpression(String expression, List<Integer> nums, List<Character> operators) {
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                operators.add(expression.charAt(i));
                i++;
            }

            int num = 0;
            while (i < expression.length() && (expression.charAt(i) >= '0' && expression.charAt(i) <= '9')) {
                num *= 10;
                num += expression.charAt(i) - '0';
                i++;
            }
            nums.add(num);
        }
    }
}