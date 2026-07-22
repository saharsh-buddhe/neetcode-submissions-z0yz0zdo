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
class Solution {
    public void reorderList(ListNode head) {
        // Edge case: empty list or single node — nothing to reorder
        if (head == null || head.next == null) return;

        // ---------- STEP 1: Find the middle of the list ----------
        // Use slow/fast pointer technique.
        // Fast moves 2 steps for every 1 step slow moves.
        // When fast reaches the end, slow will be at the middle.
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;       // moves 1 step
            fast = fast.next.next;  // moves 2 steps
        }
        // At this point, 'slow' is the last node of the FIRST half.
        // Example: [2,4,6,8] -> slow lands on 4 (first half = 2,4 | second half = 6,8)

        // ---------- STEP 2: Split the list into two halves ----------
        ListNode secondHalf = slow.next; // start of second half
        slow.next = null;                // cut the link -> first half now ends properly

        // ---------- STEP 3: Reverse the second half ----------
        // Standard linked list reversal using prev/curr pointers.
        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode nextTemp = curr.next; // save next node before overwriting
            curr.next = prev;              // reverse the pointer
            prev = curr;                   // move prev forward
            curr = nextTemp;                // move curr forward
        }
        secondHalf = prev; // 'prev' is now the head of the reversed second half
        // Example: second half [6,8] becomes [8,6]

        // ---------- STEP 4: Merge the two halves by alternating nodes ----------
        ListNode firstHalf = head;
        // We merge until the second half runs out.
        // (First half will always be >= second half in length, so this is safe.)
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;   // save next node of first half
            ListNode temp2 = secondHalf.next;  // save next node of second half

            firstHalf.next = secondHalf;       // link first -> second
            secondHalf.next = temp1;           // link second -> next of first (continue the chain)

            firstHalf = temp1;                 // advance first half pointer
            secondHalf = temp2;                // advance second half pointer
        }
        // Example merge: first=[2,4], second=[8,6]
        // 2 -> 8 -> 4 -> 6  (matches expected output)
    }
}
