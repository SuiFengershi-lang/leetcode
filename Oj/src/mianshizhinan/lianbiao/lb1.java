/*
* 合并k个有序链表
* */
package mianshizhinan.lianbiao;

public class lb1 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 1, 3, 4, 2, 6};
        ListNode[] lists = intToListNode(nums);
        ListNode head = mergeKLists(lists);
        printLinkedList(head);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode[] intToListNode(int[] nums) {
        ListNode[] lists = new ListNode[nums.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ListNode(nums[i]);
        }
        return lists;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
