def solution(arr, queries):
    for i,j in queries:
        tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    return arr