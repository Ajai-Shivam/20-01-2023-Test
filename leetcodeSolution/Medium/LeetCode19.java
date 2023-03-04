class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    int size = 0;
            ListNode temp = head;
            while(temp!=null){
                size++;
                temp =  temp.next;
            }
            temp = head;
	if(n == size){
		head = temp.next;
	}else{
	for(int i =1;i<size-n;i++){
		temp = temp.next;
	}
	ListNode temp2 = temp.next;
		temp.next = temp2.next;
	}
		return head;	
    }
}
