class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0)
            maxHeap.add(num);

        else {
            if(num < maxHeap.peek())
                maxHeap.add(num);
            else
                minHeap.add(num);
        }

        if(maxHeap.size() == minHeap.size() + 2)
            minHeap.add(maxHeap.remove());
        if(maxHeap.size() + 1 == minHeap.size())
            maxHeap.add(minHeap.remove());

    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size() + 1)
            return maxHeap.peek();
        
        else if(maxHeap.size() + 1 == minHeap.size())
            return minHeap.peek();
        
        else
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */