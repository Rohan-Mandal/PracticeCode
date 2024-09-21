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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head, prev = null, temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int eachBucketNodes = length / k;
        int remainderNodes = length % k;
        ListNode[] result = new ListNode[k];
        for(int j = 0; curr != null && j < k; j++){
            result[j] = curr;
            for(int count = 1; count <= eachBucketNodes + (remainderNodes > 0 ? 1 : 0); count++){
                prev = curr;
                curr = curr.next;
            }
            if(prev != null){
                prev.next = null;
            }
            remainderNodes--;
        }
        return result;
    }
}