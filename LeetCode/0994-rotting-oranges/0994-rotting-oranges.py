class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m,n = len(grid), len(grid[0])
        rotten = collections.deque()
        d = [(-1,0),(1,0),(0,-1),(0,1)]
        fresh = 0
        level = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    rotten.append([i,j,level])
        
        while rotten :
            x, y, level = rotten.popleft()
            for dx,dy in d:
                nx = x + dx
                ny = y + dy
                
                if 0<=nx<m and 0<=ny<n and grid[nx][ny] == 1:
                    rotten.append([nx,ny,level+1])
                    fresh -= 1
                    grid[nx][ny] = 2
    
        return level if fresh == 0 else -1