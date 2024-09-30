class CustomStack {
    private List<Integer> st;    
    private List<Integer> increments; 
    private int maxSize;  

     public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        st = new ArrayList<>();
        increments = new ArrayList<>();
    }
    
    public void push(int x) {
        if (st.size() < maxSize) {
            st.add(x);
            increments.add(0);
        }
    }
    
    public int pop() {
        if (st.size() == 0) {
            return -1;
        }

        int idx = st.size() - 1;
        
        if (idx > 0) {
            increments.set(idx - 1, increments.get(idx - 1) + increments.get(idx));
        }

        int topVal = st.get(idx) + increments.get(idx); 
        st.remove(idx); 
        increments.remove(idx); 
        
        return topVal; 
    }
    
    public void increment(int k, int val) {
        int idx = Math.min(k, st.size()) - 1; 
        if (idx >= 0) {
            increments.set(idx, increments.get(idx) + val);
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