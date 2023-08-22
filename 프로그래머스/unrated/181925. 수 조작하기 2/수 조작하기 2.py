def solution(numLog):
    answer = ''
    for i in range(1,len(numLog)):
        n = numLog[i] - numLog[i-1]
        if n == 1:
            answer += 'w'
        if n == -1:
            answer += 's'
        if n == 10:
            answer += 'd'
        if n == -10:
            answer += 'a'
    
    return answer