class MyCircularDeque {

    private List<Integer> deque;
    private int limit;
    private int count;

    public MyCircularDeque(int k) {
        this.deque = new ArrayList<>();
        this.limit = k;
        this.count = 0;
    }
    
    public boolean insertFront(int value) {
        if (this.count >= this.limit) {
            return false;
        }

        this.deque.add(0, value);
        this.count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (this.count >= this.limit) {
            return false;
        }

        this.deque.add(value);
        this.count++;
        return true;
    }
    
    public boolean deleteFront() {
        if (this.count == 0) {
            return false;
        }

        this.deque.remove(0);
        this.count--;
        return true;
    }
    
    public boolean deleteLast() {
        if (this.count == 0) {
            return false;
        }

        this.deque.remove(this.count - 1);
        this.count--;
        return true;
    }
    
    public int getFront() {
        if (this.count == 0) {
            return -1;
        }

        return this.deque.get(0);
    }
    
    public int getRear() {
        if (this.count == 0) {
            return -1;
        }

        return this.deque.get(this.count - 1);
    }
    
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    public boolean isFull() {
        return this.count == this.limit;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */