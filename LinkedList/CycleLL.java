// https://leetcode.com/problems/linked-list-cycle/

/**
 * Definition for singly-linked list.
 * static class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class CycleLL {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}