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
    public ListNode mergeNodes(ListNode head) {
        //ex. head = [0,3,1,0,4,5,2,0]
        //앞에 시작 노드 추가
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        
        //List 순회, 무조건 0으로 시작함
        while( head != null && head.next != null ){
            //prev = dummy, prev.next = 0 이고 prev.next에 값을 누적해서 저장할거임 
            prev.next = head;
            head = head.next;
            
            //head.val이 0이 아니면 prev.next에 값 저장
            while ( head != null && head.val != 0 ){
                prev.next.val += head.val;
                head = head.next;
            }
            
            //prev = 4, prev.next = 0
            prev = prev.next;
        }
        prev.next = null;
        return dummy.next;
    }
}