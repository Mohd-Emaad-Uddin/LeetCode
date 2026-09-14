class Pair implements Comparable<Pair> {
    int diff, ele;

    public Pair(int diff, int ele) {
        this.diff = diff;
        this.ele = ele;
    }

    public int compareTo(Pair p) {
        if(this.diff == p.diff)
            return Integer.compare(this.ele, p.ele);
        return Integer.compare(this.diff, p.diff);
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Heap Solution
        /*
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: arr) {
            pq.add(new Pair(Math.abs(num - x), num));
            if(pq.size() > k)
                pq.remove();
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            list.add(p.ele);
        }

        Collections.sort(list);
        return list;
        */

        // Two Pointers Solution - Better Approach
        int low = 0, high = arr.length - 1;
        while(high - low >= k) {
            if(Math.abs(x - arr[low]) > Math.abs(x - arr[high]))
                low++;
            else
                high--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=low; i<low+k; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}