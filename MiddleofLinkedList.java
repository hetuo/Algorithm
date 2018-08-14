/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode dummy = head;
        while (dummy != null) {
            list.add(dummy);
            dummy = dummy.next;
        }
        return list.size() == 0 ? null : list.get(list.size() / 2);
    }
}
