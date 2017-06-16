/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideConquer(lists, 0, lists.length -1);
    }
    private ListNode divideConquer(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start)/2;
        // divide
        ListNode left = divideConquer(lists, start, mid);
        ListNode right = divideConquer(lists, mid+1, end);
        // conquer
        return merge(left, right);
    }
    private ListNode merge (ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        // while (left != null) {
        //     tail.next = left;
        //     left = left.next;
        //     tail = tail.next;
        // }
        
        // while (right != null) {
        //     tail.next = right;
        //     right = right.next;
        //     tail = tail.next;
        // }
        if (left != null) {
            tail.next = left;
        } else{
            tail.next = right;    
        }
        return dummy.next;
    }
    
    
    
}
