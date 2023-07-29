from collections import Counter

def solution(k, tangerine):
    answer = 0
    counter = Counter(tangerine)
    sort_ = sorted(counter.items(),key=lambda x:x[1],reverse=True)
    
    for i in sort_:
        k -= i[1]
        answer += 1
        
        if k <= 0:
            break
            
    return answer