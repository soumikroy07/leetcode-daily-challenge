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
    /*
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode curr = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        map.put(sum, null);
        while(curr != null){
            sum += curr.val;
            if(map.containsKey(sum)){
                ListNode node = map.get(sum);
                if(node == null){
                    head = curr.next;
                    // return head;
                }else{
                    node.next = curr.next;
                }
                
                // break;
            }
            map.put(sum, curr);
            curr = curr.next;
        }
        return head;
    }
    */
        public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> m = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;
            if (m.containsKey(prefix)) {
                cur =  m.get(prefix).next;
                int p = prefix + cur.val;
                while (p != prefix) {
                    m.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                m.get(prefix).next = cur.next;
            } else {
                m.put(prefix, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}