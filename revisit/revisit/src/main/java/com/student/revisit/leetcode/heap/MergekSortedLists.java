package com.student.revisit.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

    // 23. Merge k Sorted Lists
    // https://leetcode.com/problems/merge-k-sorted-lists/
    // use minheap of size k
    // add 1st node of all sorted lists to minheap of size k
    // now while minheap is not empty
    // poll min node and add min node to next of merged list
    // add next of min node to minheap if not null else
    // add next of peek node to minheap if not null

    public ListNode mergeKLists(ListNode[] lists) {
        final int k = lists.length;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(k, Comparator.comparingInt(node -> node.val));
        for(int x = 0; x <= k - 1; x++) {
            if(lists[x] != null) {
                minheap.add(lists[x]);
            }
        }
        ListNode zeroth = new ListNode();
        ListNode curr = zeroth;
        while (!minheap.isEmpty()) {
            ListNode poll = minheap.poll();
            if(poll.next != null) {
                minheap.add(poll.next);
            } else {
                ListNode peek = minheap.peek();
                if (peek != null && peek.next != null) {
                    minheap.add(peek.next);
                }
            }
            curr.next = poll;
            curr = curr.next;
        }
        return zeroth.next;
    }

    private class ListNode {
        private int val;
        private ListNode next;
    }

}
