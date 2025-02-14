class ProductOfNumbers {
    private List<Integer> prefixProduct;
    
    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1); // Initializing with 1 for easier division calculations
    }
    
    public void add(int num) {
        if (num == 0) {
            // Reset on encountering 0, as it invalidates previous products
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            int lastProduct = prefixProduct.get(prefixProduct.size() - 1);
            prefixProduct.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k >= size) return 0; // If k is larger than the available numbers (due to reset), return 0
        return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */