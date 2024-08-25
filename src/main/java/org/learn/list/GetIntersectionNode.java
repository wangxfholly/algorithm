package org.learn.list;

/**
 * 获取链表相交的node
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (curA != null) {
            curA = curA.next;
            lengthA++;
        }
        while (curB != null) {
            curB = curB.next;
            lengthB++;
        }

        curA = headA;
        curB = headB;
        if (lengthB > lengthA) {
            int tmplen = lengthA;
            lengthA = lengthB;
            lengthB = tmplen;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        int gap = lengthA - lengthB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
