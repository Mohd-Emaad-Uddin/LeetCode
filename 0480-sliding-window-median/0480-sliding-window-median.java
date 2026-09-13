class Solution {
    public double[] medianSlidingWindow(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<k; i++) {
            int num = arr[i];
            if(maxHeap.size() == 0) {
                maxHeap.add(num);
                continue;
            }

            if(num < maxHeap.peek())
                maxHeap.add(num);
            else
                minHeap.add(num);

            if(maxHeap.size() == minHeap.size() + 2)
                minHeap.add(maxHeap.remove());
            if(maxHeap.size() + 1 == minHeap.size())
                maxHeap.add(minHeap.remove());
        }

        int n = arr.length;
        double[] res = new double[n-k+1];
        int j = 0;

        Map<Integer, Integer> map = new HashMap<>();
        res[j] = (k % 2 == 1) ? maxHeap.peek() : ((double)minHeap.peek() + maxHeap.peek()) / 2.0; 

        for(int i=k; i<n; i++) {
            int numA = arr[i], numR = arr[i-k];

            map.put(numR, map.getOrDefault(numR, 0) + 1);
            int count = 0;
            // maxHeap Add +1, Remove -1
            // minHeap Add -1, Remove +1

            if(numA <= maxHeap.peek()) {
                maxHeap.add(numA);
                count += 1;
            }
            else {
                minHeap.add(numA);
                count -= 1;
            }

            if(numR <= maxHeap.peek())
                count -= 1;
            else
                count += 1;

            
            // counter 0 + -
            if(count > 0)
                minHeap.add(maxHeap.remove());
            if(count < 0)
                maxHeap.add(minHeap.remove());

            
            while(!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) > 0) {
                int ele = maxHeap.peek();
                maxHeap.remove();
                map.put(ele, map.get(ele) - 1);
            }

            while(!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) > 0) {
                int ele = minHeap.peek();
                minHeap.remove();
                map.put(ele, map.get(ele) - 1);
            }


            res[++j] = (k % 2 == 1) ? maxHeap.peek() : ((double)minHeap.peek() + maxHeap.peek()) / 2.0; 
        }

        return res;
    }
}