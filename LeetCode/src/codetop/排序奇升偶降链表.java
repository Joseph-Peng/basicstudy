package codetop;

public class 排序奇升偶降链表 {

    public static void main(String[] args) {
        排序奇升偶降链表 test = new 排序奇升偶降链表();
        int[] input = {1,8,3,6,5,4,7,2};
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for(int i = 0; i<input.length;++i){
            cur.next = new ListNode(input[i]);
            cur = cur.next;
        }
        ListNode res = test.sortList(dummy.next);
        while (res!=null){
            System.out.print(res.val+",");
            res = res.next;
        }

    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){
            this.val = x;
        }
    }

    public ListNode sortList(ListNode head){
        ListNode dummyOdd = new ListNode();
        ListNode dummyEven = new ListNode();
        ListNode odd = dummyOdd;
        ListNode even = dummyEven;

        ListNode cur = head;
        while (cur!=null){
            odd.next = cur;
            odd = odd.next;

            cur = cur.next;
            if (cur == null) break;

            even.next = cur;
            even = even.next;
            cur = cur.next;
        }
        even.next = null;
        odd.next = null;

        // 翻转odd链表
        even = reverseList(dummyEven.next);
        odd = dummyOdd.next;

        return mergeList(odd,even);
    }

    private ListNode mergeList(ListNode odd, ListNode even) {
        if (odd == null || even == null) return odd == null ? even : odd;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (even!=null && odd!=null){
            if(even.val < odd.val){
                cur.next = even;
                even = even.next;
            }else{
                cur.next = odd;
                odd = odd.next;
            }
            cur = cur.next;
        }
        cur.next = odd == null ? even : odd;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
