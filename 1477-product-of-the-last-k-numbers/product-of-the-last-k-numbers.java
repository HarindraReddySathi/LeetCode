class ProductOfNumbers {
    List<Integer> prods;
    int prod; 
    public ProductOfNumbers() {
       prods = new ArrayList<>();
       prods.add(1);
       prod = 1;
    }

    public void add(int num) {
        if(num != 0) {
            prods.add(num*prod);
            prod*=num;
        }
        else {
            prods = new ArrayList<>();
            prods.add(1);
            prod = 1;
        }
    }

    public int getProduct(int k) {
        int n = prods.size();
        return k<n ? prod/prods.get(n-k-1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */