import java.util.List;

public class MyLinkedList {

    private class ListNode {
        private Object data;
        private ListNode next;

        private ListNode(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListNode head;
    private int size;

    public MyLinkedList() {
        this.head = new ListNode(null);
        this.size = 0;
    }

    public void add(Object data) {
        insert(data, size);
    }

    public void insert(Object data, int idx) {
        if (idx < 0 || idx > size)
            throw new IndexOutOfBoundsException("This index is invalid.");
        int i = 0;
        ListNode cur = head;
        while (i < idx - 1)
            cur = cur.next;
        ListNode toAdd = new ListNode(data);
        if (size == 0) {
            this.head = toAdd;
        } else {
            toAdd.next = cur.next;
            cur.next = toAdd;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Object remove(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("This index is invalid.");
        int i = 0;
        ListNode cur = head;
        while (i < idx - 1)
            cur = cur.next;
        Object toRet = cur.next.data;
        cur.next = cur.next.next;
        if (idx == 0)
            this.head = head.next;
        size--;
        return toRet;
    }

    public int contains(Object data) {
        int i = 0;
        ListNode cur = head;
        while (i < size) {
            if (cur.data == data)
                return i;
            cur = cur.next;
            i++;
        }
        return -1;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (other.getClass() != this.getClass())
            return false;
        MyLinkedList otherList = (MyLinkedList) other;
        boolean result = size == otherList.size();
        if (result) {
            int i = 0;
            ListNode cur = head;
            ListNode otherCur = otherList.head;
            while (i < size) {
                if (cur.data != otherCur.data)
                    return false;
                i++;
                cur = cur.next;
                otherCur = otherCur.next;
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder toRet = new StringBuilder();
        toRet.append("[");
        int i = 0;
        ListNode cur = head;
        while (i < size - 1) {
            toRet.append(cur.data + ", ");
            cur = cur.next;
            i++;
        }
        toRet.append(cur.data + "]");
        return toRet.toString();
    }

}