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
    public ListNode doubleIt(ListNode head) {
        List<Integer> originalValues = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            originalValues.add(current.val);
            current = current.next;
        }

        List<Integer> doubledValues = new ArrayList<>();
        int carry = 0;

        for (int i = originalValues.size() - 1; i >= 0; i--) {
            int val = originalValues.get(i) * 2 + carry;
            doubledValues.add(val % 10);
            carry = val / 10;
        }

        while (carry > 0) {
            doubledValues.add(carry % 10);
            carry /= 10;
        }

        ListNode newHead = null;
        ListNode tail = null;

        for (int i = doubledValues.size() - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(doubledValues.get(i));
            if (newHead == null) {
                newHead = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return newHead;
    }
}
