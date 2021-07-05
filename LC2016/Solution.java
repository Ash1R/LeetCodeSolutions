//https://leetcode.com/problems/reverse-linked-list/ 

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode ans;
        while (head != null) {
          ListNode next = head.next;
          head.next = ans;
          ans = head;
          head = next;
      }
    return ans;
    }
