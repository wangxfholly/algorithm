package org.learn.list;

/**
 * 交换相邻的节点
 */
public class SwapPairs {
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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, null);//设置一个虚拟头结点
        dummy.next = head;//将虚拟头节点指向head，这样方便后面删除操作
        ListNode cur = dummy;
        ListNode temp; //临时节点，保存两个节点后面的节点
        ListNode firstNode;//临时节点，保存两个节点之中的第一个节点
        ListNode secondNode;//临时节点，保存两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null) {

            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dummy.next;
    }
}
