class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a1,a2)->(a2-a1));
        minHeap = new PriorityQueue<>((a1,a2)->(a1-a2));
    }
    //maxHeap size = > minHeap. maxHeap contains small elements with the max one stay at top. minHeap contains large elements with the smallest stay at top.
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        if(maxHeap.size() == minHeap.size()+2){
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size() == maxHeap.size()+1){
            maxHeap.add(minHeap.poll());
        }  
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */