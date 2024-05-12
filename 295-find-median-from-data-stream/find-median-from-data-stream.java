class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() && right.isEmpty()) {
            left.add(num);
        }else{
            if(left.peek()>=num) left.add(num);
            else right.add(num);
            if(left.size()-right.size()>1){
                right.add(left.poll());
            }else if(left.size()-right.size()<-1){
                left.add(right.poll());
            }
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (0d+left.peek()+right.peek())/2;
        }
        return (left.size() >right.size()) ? left.peek() : right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */