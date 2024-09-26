class MyCalendar {
    PriorityQueue<int[]> pq;

    public MyCalendar() {
        pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        for (int[] event: pq) {
            if (event[0] >= end) {
                break;
            }
            
            if (!(event[1] <= start || end <= event[0])) {
                return false;
            }
        }
        pq.offer(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */