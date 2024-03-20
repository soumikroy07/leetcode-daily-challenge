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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode mid1 = list1;
        ListNode mid2 = list1;
        while(a > 1){
            mid1 = mid1.next;
            a--;
        }
        while(b >= 0){
            mid2 = mid2.next;
            b--;
        }

        mid1.next = list2;
        while(mid1.next != null){
            mid1 = mid1.next;
        }

        mid1.next = mid2;
        return list1;
    }
}