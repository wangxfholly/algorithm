package org.learn.list;

/**
 * 移除元素
 *
 * @author holly
 * @link <a href="URL_ADDRESS">移除元素</a>
 */
public class RemoveElements {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            next = next;
        }
    }

    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode head = new ListNode(1,
            new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null)))))));
        ListNode result = removeElements.removeElements(head, 6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * removeElements by dummy node
     *
     * @param head headNode
     * @param val  val need remove
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, null);
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
