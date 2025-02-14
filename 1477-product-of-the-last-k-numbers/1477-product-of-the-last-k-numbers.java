class ProductOfNumbers {

    private List<Integer> numbers;

    public ProductOfNumbers() {
        numbers = new ArrayList<>();
    }
    
    public void add(int num) {
        numbers.add(num);
    }
    
    public int getProduct(int k) {
        int size = numbers.size();
        int product = 1;

        for(int i = size - k; i < size; i++){
            product *= numbers.get(i);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */