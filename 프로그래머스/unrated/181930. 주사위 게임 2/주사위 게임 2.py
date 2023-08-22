def solution(a, b, c):
    answer = 1
    num = 4 - len(set([a,b,c]))
        
    for i in range(1,num+1):
        answer *= a**i + b**i + c**i
    return answer