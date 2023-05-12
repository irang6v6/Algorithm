# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # 중간지점 찾기
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        
        # 뒤쪽 뒤집기
        prev, cur = None, slow.next
        while cur :
            tmp = cur.next
            cur.next = prev
            prev = cur
            cur = tmp
        slow.next = None
    
        # merge
        head1, head2 = head, prev
        while head2 :
            tmp = head1.next
            head1.next = head2
            head1 = head2
            head2 = tmp