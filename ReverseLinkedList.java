class ReverseLinkedList {
    ListNode prev = null;

    public ListNode reverseList(ListNode head) {
        return reverseRecursively(head);

    }

    public ListNode reverseIteratively(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    public ListNode reverseRecursively(ListNode head) {
        if (head == null)
            return prev;
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        return reverseRecursively(next);

    }
}
