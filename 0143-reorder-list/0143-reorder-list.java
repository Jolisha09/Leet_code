/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode sl=head;
        ListNode fs=head;
        while(fs!=null&&fs.next!=null)
        {
            sl=sl.next;
            fs=fs.next.next;
        }
    ListNode prev = null;
    ListNode curr = sl.next;
     sl.next = null;
    while (curr != null) {
        ListNode next = curr.next; 
        curr.next = prev; 
        prev = curr;     
        curr = next;     
    }
    ListNode first = head;
ListNode second = prev;

while (second != null) {
    ListNode t1 = first.next;
    ListNode t2 = second.next;
    first.next = second;
    second.next = t1;
    first = t1;
    second = t2;
    }
    }
}