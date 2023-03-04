public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
if(head == null || head.next == null){
            return null;
        }
        ListNode  slow = head;
        ListNode fast = head;
        boolean yesorNo = false;
        while(fast.next != null && fast.next.next != null){
			slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                yesorNo = true;
                break;
            }
        }
        if(yesorNo){
        fast = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        }
        return null;
    }
}
