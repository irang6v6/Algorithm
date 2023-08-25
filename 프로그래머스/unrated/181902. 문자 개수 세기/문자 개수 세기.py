def solution(my_string):
    answer = [0] * 52
    for c in my_string:
        n = ord(c)
        if n <= 90:
            answer[n - 65] += 1
        else :
            answer[n - 71] += 1
    return answer