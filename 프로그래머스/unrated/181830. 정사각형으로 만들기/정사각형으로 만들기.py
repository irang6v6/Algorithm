def solution(arr):
    answer = [[]]
    l = max(len(arr),len(arr[0]))
    answer = [[0]*l for _ in range(l)]
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            answer[i][j] = arr[i][j]
    return answer