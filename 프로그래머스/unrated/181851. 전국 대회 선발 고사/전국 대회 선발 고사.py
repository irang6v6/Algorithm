def solution(rank, attendance):
    answer = 0
    able = []
    for i in range(len(rank)):
        if attendance[i]:
            able.append([rank[i],i])
    arr = sorted(able)[:3]
    print(arr)
    return 10000 * arr[0][1] + 100 * arr[1][1] + arr[2][1]