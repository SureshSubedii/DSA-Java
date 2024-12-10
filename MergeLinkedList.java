
class MergeLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode list = dummy;

        if (list1 == null && list2 == null)
            return dummy.next;

        ListNode current = list1;
        System.out.println(dummy.val);

        while ((current != null || list2 != null) && list != null) {

            if (current == null && list2 != null) {
                list.val = list2.val;
                list2 = list2.next;
                if (list2 != null) {
                    list.next = new ListNode();
                }

            }
            if (list2 == null && current != null) {
                list.val = current.val;
                current = current.next;
                if (current != null) {
                    list.next = new ListNode();
                }

            }

            if (current != null && list2 != null) {
                if (current.val < list2.val) {
                    list.val = current.val;
                    list.next = new ListNode(list2.val);
                    current = current.next;

                } else {
                    list.val = list2.val;
                    list.next = new ListNode(current.val);
                    list2 = list2.next;

                }
            }
            list = list.next;

        }

        return dummy;

    }
}