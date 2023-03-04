class AddTwoNumnbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        int carry = 0;
        while(l1 !=null && l2!=null){
            ListNode ad = new ListNode(l1.val+l2.val+carry);
            if((l1.val+l2.val+carry)>9){
                ad.val = (l1.val+l2.val+carry)%10;
                carry = (l1.val+l2.val+carry)/10;

            }else{
                carry = 0;
            }
            temp.next = ad;
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while (l1!= null){
            ListNode ad =new ListNode(l1.val+carry);
            if((l1.val+carry)>9){
                ad.val = (l1.val+carry)%10;
                carry = (l1.val+carry)/10;
            }else{
                carry = 0;
            }
            temp.next = ad;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2!=null){
            ListNode ad =new ListNode(l2.val+carry);
            if((l2.val+carry)>9){
                ad.val = (l2.val+carry)%10;
                carry = (l2.val+carry)/10;
            }else{
                carry = 0;
            }
            temp.next = ad;
            l2 = l2.next;
            temp = temp.next;
        }
        if(carry>0){
            ListNode aa = new ListNode(carry);
            temp.next = aa;
            temp = temp.next;
        }
    return ans.next;
    }
}
