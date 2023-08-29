def solution(arr):
    answer = []
    l = 1
    while len(arr) > l:
        l *= 2
    return arr + [0] * (l - len(arr))