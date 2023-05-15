public class Solution {

    public ListNode swapNodes(ListNode head, int k) {

        // Create three pointers to the nodes
        ListNode x = head;
        ListNode y = head;
        ListNode t = head;

        // Iterate until we reach the k-th node from the beginning
        while (k > 1) {
            x = x.next;
            t = t.next;
            k--;
        }

        // Iterate until the pointer t reaches the last node
        while (t.next != null) {
            y = y.next;
            t = t.next;
        }

        // Swap the values of the two nodes
        int temp = x.val;
        x.val = y.val;
        y.val = temp;

        // Return the head of the linked list
        return head;
    }
}
