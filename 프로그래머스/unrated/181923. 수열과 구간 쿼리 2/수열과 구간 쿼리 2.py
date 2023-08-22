def solution(arr, queries):
    answer = []
    for s,e,k in queries:
        tmp = 1000001
        for i in range(s,e+1):
            if arr[i] > k and arr[i] < tmp:
                tmp = arr[i] 
        if tmp == 1000001:
            tmp = -1
        answer.append(tmp)
    return answer