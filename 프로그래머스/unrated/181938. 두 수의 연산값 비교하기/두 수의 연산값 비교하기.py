def solution(a, b):
    answer = 0
    p = int(str(a)+str(b))
    m = 2 * a * b
    
    if p >= m:
        answer = p
    else:
        answer = m
        
    return answer