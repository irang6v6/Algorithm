def solution(n):
    # 총 몇 칸인지 계산
    total = (n * (n + 1))/2
    answer = []
    
    # 2차원 리스트 생성
    triangle = [[0]*n for _ in range(n)]
    
    # 방향 저장하고 (하,우,좌상)
    dx, dy =  [0, 1, -1], [1, 0, -1]
    x, y, d, order = 0, 0, 0, 1
    
    # 방문할 칸이 남아있다면 탐색
    while total > 0 :
        triangle[y][x] = order
        order += 1
        total -= 1
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0 or nx >= n or ny < 0 or ny >= n or triangle[ny][nx] != 0 :
            d = (d+1) % 3
        x = x + dx[d]
        y = y + dy[d]
    
    
    # 2중 for문 돌면서 새로운 1차원 리스트에 순서 저장 
    for i in range(n):
        for j in range(i+1):
            answer.append(triangle[i][j])
    
    return answer