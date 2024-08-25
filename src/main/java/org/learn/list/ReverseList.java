package org.learn.list;

/**
 * 链表反转
 */
public class ReverseList {

    /**
     * 迭代实现
     *
     * @param head 头节点
     * @return ListNode
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归实现
     *
     * @param cur 当前节点
     * @param pre 前一个节点
     * @return listNode
     */
    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        return reverse(cur, pre);
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }
}
