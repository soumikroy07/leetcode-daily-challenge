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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head, front = head;
        while(front != null){
            while(!st.isEmpty() && st.peek().val < front.val){
                st.pop();
            }
            if(st.isEmpty()){
                st.push(front);
                head = front;
                front = front.next;
                continue;
            }else{
                st.peek().next = front;
                st.push(front);
                front = front.next;
                continue;
            }
            // st.push(front);
            // front = front.next;
        }
        
        return head;
    }
}