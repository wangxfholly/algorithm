package org.learn.list;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    //size 存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode dummyHead;

    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头节点
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = dummyHead;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 在链表最前面插入一个节点，等价于在第0个元素前添加 addAtHead(val) 等价于 addAtIndex(0, val)
     *
     * @param val val
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        size++;
    }

    /**
     * 在链表最后面添加一个节点，等价于在第size个元素后添加
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    /**
     * 在第 index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点 如果 index 大于链表的长度，则返回空·
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        size++;
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    /**
     * 删除第index个节点
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}

/**
 * 双向链表
 */
class ListNode2 {
    int val;
    ListNode2 pre, next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }
}

class MyLinkedList2 {
    //size 存储链表元素的个数
    int size;
    //记录链表的虚拟头节点和尾节点
    ListNode2 dummyHead, dummyTail;

    public MyLinkedList2() {
        this.size = 0;
        this.dummyHead = new ListNode2();
        this.dummyTail = new ListNode2();
        //这一步非常关键，否则在加入头节点的操作中会出现null.next的错误
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode2 cur = dummyHead;
        //判断是哪一边遍历时间更短
        if (index >= size / 2) {
            //tail 开始
            cur = dummyTail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.pre;
            }
        } else {
            for (int i = 0; i < size - index; i++) {
                cur = cur.next;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index >= size) {
            return;
        }
        size++;
        //找到前驱
        ListNode2 pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //新建节点
        ListNode2 newNode = new ListNode2(val);
        newNode.next = pre.next;
        pre.next.pre = newNode;
        newNode.pre = pre;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        //找到前驱
        ListNode2 pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next.next.pre = pre;
        pre.next = pre.next.next;
    }
}
