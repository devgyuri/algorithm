class Solution {
    public int minSwaps(String s) {
        int swapCount = 0;
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
}