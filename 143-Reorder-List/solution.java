/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode left = head;
        ListNode right = divideList(head);
        ListNode rightReversed = reverse(right);
        merge(left, rightReversed);
    }
    
    private ListNode divideList(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode result = p1.next;
        p1.next = null;
        return result;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode par = head;
        ListNode son = par.next;
        while (son != null) {
            ListNode grandSon = son.next;
            son.next = par;
            par = son;
            son = grandSon;
        }
        return par;
    }
    
    private void merge(ListNode left, ListNode right) {
        boolean isLeft = false;
        ListNode cur = left;
        left = left.next;
        while (left != null && right != null) {
            if (isLeft) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
            isLeft = !isLeft; //don't forget this
        }
        
        if (left != null) {
            cur.next = left;
        }
        System.out.println(1);
        if (right != null) {
            cur.next = right;
        }
        System.out.println(2);
    }
}