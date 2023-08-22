def solution(a, b, c):
    answer = 1
    num = len(set([a,b,c]))
    if num == 3:
        num = 1
    elif num == 1:
        num = 3
        
    for i in range(1,num+1):
        answer *= a**i + b**i + c**i
    return answer