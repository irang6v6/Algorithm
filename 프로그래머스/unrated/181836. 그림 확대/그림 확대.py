def solution(picture, k):
    answer = []
    for p in picture:
        m = ''
        for c in p:
            m += c * k
        for i in range(k):
            answer.append(m)
    return answer