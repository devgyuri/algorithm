class CustomStack {

    private int[] array;
    private int top;
    private int limit;

    public CustomStack(int maxSize) {
        this.array = new int[maxSize];
        this.top = 0;
        this.limit = maxSize;
    }
    
    public void push(int x) {
        if (top == limit) {
            return;
        }
        array[top] = x;
        top++;
    }
    
    public int pop() {
        if (top == 0) {
            return -1;
        }
        top--;
        return array[top];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < top && i < k; i++) {
            array[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */