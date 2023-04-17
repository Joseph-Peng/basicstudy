package lc701to800;

/**
 * @author Joseph Peng
 * @date 2022/9/23 11:02
 */
public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.print("addAtHead");
        linkedList.addAtHead(2);
        linkedList.print("addAtHead");
        linkedList.addAtHead(1);
        linkedList.print("addAtHead");
        linkedList.addAtIndex(3,0);
        linkedList.print("addAtIndex");
        linkedList.deleteAtIndex(2);
        linkedList.print("deleteAtIndex");
        linkedList.addAtHead(6);
        linkedList.print("addAtHead");
        linkedList.addAtTail(4);
        linkedList.print("addAtTail");
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.print("addAtHead");
        linkedList.addAtIndex(5,0);
        linkedList.print("addAtIndex");
        linkedList.addAtHead(6);
        linkedList.print("addAtHead");
    }

    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        ListNode cur = head.next;
        while(cur != tail && index != 0){
            cur = cur.next;
            index--;
        }
        return cur == tail ? -1 : cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        ListNode cur = head.next;
        while(cur != tail && index != 0){
            cur = cur.next;
            index--;
        }
        if(cur == tail) return;
        ListNode node = new ListNode(val);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode cur = head.next;
        while(cur != tail && index != 0){
            cur = cur.next;
            index--;
        }
        if(cur == tail) return;
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
        size--;
    }

    class ListNode{
        ListNode next;
        ListNode prev;
        int val;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }

    public void print(String ops){
        ListNode cur = head.next;
        System.out.print(ops + ":");
        while (cur != tail){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
