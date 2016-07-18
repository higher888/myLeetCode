/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        //first copy .next since we need .random to be exist so that we can track every node
        RandomListNode dummy1 = new RandomListNode(0);
        RandomListNode dummy2 = new RandomListNode(0);
        dummy1.next = head;
        while (head != null){
            RandomListNode newNode = new RandomListNode(head.label);
            RandomListNode temp = head.next;
            head.next = newNode;
            newNode.next = temp;
            head = temp;
        }
        //set up random 
        head = dummy1.next;
        RandomListNode newHead = dummy2.next;
        while (head != null){
            if (head.random != null){
                newHead.random = head.random.next; //set up random
            }// note that we cannot split list at the same of setting up random, because some randoms may track back and splitted list cannot give the right answer.
            head = head.next;
        }
        //split into two list
        dummy2.next = dummy1.next.next;
        head = dummy1.next;
        newHead = dummy2.next;
        while (head != null){
            head.next = newHead.next;
            if (head.next != null){
                newHead.next = head.next.next;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return dummy2.next;
    }
}