class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int listSize = 0;
        while(current != null){
            listSize ++;
            current = current.next;
        }
        int middleIndex = listSize/2;
        for(int i = 0; i < middleIndex; i++){
            head = head.next;
        }
        return head;


    }
}