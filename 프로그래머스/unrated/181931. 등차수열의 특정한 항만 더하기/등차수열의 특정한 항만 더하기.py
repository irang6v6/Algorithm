def solution(a, d, included):
    answer = 0
    for b in range(len(included)):
        if included[b] == True:
            answer += a + (d * b)
    return answer