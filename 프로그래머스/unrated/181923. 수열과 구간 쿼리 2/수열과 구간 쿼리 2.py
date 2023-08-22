def solution(arr, queries):
    answer = []
    for s,e,k in queries:
        tmp = 1000001
        for i in range(s,e+1):
            if arr[i] > k and arr[i] < tmp:
                tmp = arr[i] 
        answer.append(tmp if tmp != 1000001 else -1)
    return answer