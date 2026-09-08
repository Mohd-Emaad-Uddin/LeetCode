/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Pair implements Comparable<Pair> {
    int data;
    ListNode next;

    public Pair(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public int compareTo(Pair p) {
        return Integer.compare(this.data, p.data);
    }
}

class Solution {

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dNode = new ListNode(-1);
        ListNode t1 = l1, t2 = l2, temp = dNode;

        while(t1 != null && t2 != null) {
            if(t1.val <= t2.val) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null)
            temp.next = t1;
        else
            temp.next = t2;

        return dNode.next;
    }

    public ListNode mergeSort(ListNode[] lists, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;

            ListNode left = mergeSort(lists, low, mid);
            ListNode right = mergeSort(lists, mid+1, high);

            return merge(left, right);
        }

        return lists[low];
    }

    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists == null || lists.length == 0)
    //         return null;
        
    //     return mergeSort(lists, 0, lists.length-1);
    // }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(ListNode head: lists) {
            if(head != null)
                pq.add(new Pair(head.val, head));
        }

        ListNode dNode = new ListNode(-1);
        ListNode curr = dNode;

        while(!pq.isEmpty()) {
            Pair p = pq.remove();

            curr.next = p.next;
            curr = curr.next;

            if(p.next.next != null) {
                ListNode nextNode = p.next.next;
                pq.add(new Pair(nextNode.val, nextNode));
            }
        }

        return dNode.next;
    }
}