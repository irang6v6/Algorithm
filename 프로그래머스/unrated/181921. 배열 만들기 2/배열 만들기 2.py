def solution(l, r):
    answer = []
    for i in range(l,r+1):
        s = set(str(i))
        if s == {'5', '0'} or s == {'5'}:
            answer.append(i)
    return answer if answer else [-1]