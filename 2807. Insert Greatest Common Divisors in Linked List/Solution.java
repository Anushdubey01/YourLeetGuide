class Solution {
    private int findGCD(int x, int y) {
        int r = 0, a, b;
        a = Math.max(x, y);
        b = Math.min(x, y);
        r = b;
        while (a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            int lVal = left.val;
            int rVal = right.val;
            int gcd = findGCD(lVal, rVal);
            ListNode nLi = new ListNode(gcd);
            left.next = nLi;
            nLi.next = right;
            left = right;
            right = right.next;
        }
        return head;
    }
}