class ProductOfNumbers {
    long product = 1l;
    List<Long> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            list.clear();
            product = 1;
        } else {
            product *= num;
            list.add(product);
        }
    }
    
    public int getProduct(int k) {
        int idx = list.size() - k - 1;

        if(k > list.size()){
            return 0;
        }
        if(idx < 0){
            return (int)product;
        } 
        return (int)(product / list.get(idx));
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */