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
    public int getDecimalValue(ListNode head) {

        StringBuilder sb = new StringBuilder();

        while(head != null){
            sb.append(head.val);
            head = head.next;
        }

        int len = sb.length();
        int result = 0;
        int power = 0;

        for(int i = len - 1; i >= 0; i--){
            if(sb.charAt(i) == '1'){
                result += Math.pow(2, power);
            }
            power++;
        }
        return result;        
    }
}