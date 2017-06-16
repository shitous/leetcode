/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head  == null) {
            return head;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newHead;
        
        while (head != null) {
            if (map.containsKey(head)) {
                newHead = map.get(head);
            } else {
                newHead = new RandomListNode(head.label);
                map.put(head, newHead);
            }
            pre.next = newHead;
            
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newHead.random = map.get(head.random);
                } else {
                    newHead.random = new RandomListNode(head.random.label);
                    map.put(head.random, newHead.random);
                }
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }
}
