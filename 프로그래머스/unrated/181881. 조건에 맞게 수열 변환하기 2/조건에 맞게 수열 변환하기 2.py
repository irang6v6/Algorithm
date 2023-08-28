import copy

def solution(arr):
    x = 0
    tmp = [] #arr(x)
    while arr != tmp:
        x += 1
        tmp = copy.deepcopy(arr)
        for i in range(len(arr)):
            if arr[i] >= 50 and arr[i] % 2 == 0:
                arr[i] /= 2
            elif arr[i] < 50 and arr[i] % 2 == 1:
                arr[i] = arr[i] * 2 + 1
    return x - 1