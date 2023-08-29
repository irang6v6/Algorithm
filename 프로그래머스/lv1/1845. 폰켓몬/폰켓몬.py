from collections import Counter
def solution(nums):
    kind = len(set(nums))
    avail = len(nums)/2
    return avail if avail <= kind else kind