class LeetCode143 {
    public void reorderList(ListNode node) {
        ListNode temp = node;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        temp = node;
        ListNode node1 = null;
        if(size%2!=0){
            for(int i = 0;i<size/2;i++){
                temp = temp.next;
            }
            node1 = temp.next;
            temp.next = null;
        }else{
            for(int i = 1;i<size/2;i++){
                temp = temp.next;
            }
            node1 = temp.next;
            temp.next = null;
        }
        temp = node;
        ListNode previous = null;
        ListNode curr = node1;
        ListNode next = null;
        while (curr != null){
             next = curr.next;
             curr.next = previous;
             previous = curr;
             curr = next;
        }
        while (previous != null){
            ListNode ad = new ListNode(previous.val);
            ad.next = temp.next;
            temp.next = ad;
            temp = temp.next.next;
            previous = previous.next;
        }
        return;
    }
}
