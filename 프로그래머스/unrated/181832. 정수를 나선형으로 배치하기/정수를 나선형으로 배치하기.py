def solution(n):
    answer = [[0] * n for _ in range(n)]
    direct = [1,1,-1,-1] #우하좌상
    d = 0
    idx_i, idx_j = 0, 0
    
    for num in range(1,n*n+1):
        answer[idx_i][idx_j] = num
        #print('i=',idx_i,'j=',idx_j,'num=',num,'d=',d,'direct=',direct[d])
        if d == 0:
            if idx_j+direct[d] >= n or answer[idx_i][idx_j+direct[d]] != 0:
                d = (d+1)%4
                idx_i += direct[d]
            else:
                idx_j += direct[d]
        elif d == 1:
            if idx_i+direct[d] >= n or answer[idx_i+direct[d]][idx_j] != 0:
                d = (d+1)%4
                idx_j += direct[d]
            else:
                 idx_i += direct[d]
        elif d == 2:
            if idx_j+direct[d] >= n or answer[idx_i][idx_j+direct[d]] != 0:
                d = (d+1)%4
                idx_i += direct[d]
            else:
                idx_j += direct[d]                
        elif d == 3:
            if idx_i+direct[d] >= n or answer[idx_i+direct[d]][idx_j] != 0:
                d = (d+1)%4
                idx_j += direct[d]   
            else:
                 idx_i += direct[d]
    return answer