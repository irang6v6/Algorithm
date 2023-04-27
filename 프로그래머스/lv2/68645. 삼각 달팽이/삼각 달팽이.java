class Solution {   
    public int[] solution(int n) {
        
        //하-우-좌상
        int dx[] = {0,1,-1}, dy[] = {1,0,-1};
        
        //피라미드 칸의 개수
        int numP = (n * (n + 1))/2;
        int[] answer = new int[numP];
        int[][] pyramid = new int[n][n];
        
        //시작칸, 순서
        int x = 0, y = 0, order = 1, d = 0;
        
        //남은 칸이 있다면
        while(numP > 0){
            pyramid[y][x] = order++;
            int nextX = x + dx[d];
            int nextY = y + dy[d];
            numP--;
            if( nextX >= n || nextX < 0 || nextY >= n || nextY < 0 || pyramid[nextY][nextX] != 0){
                d = (d + 1) % 3;
            }
            x = x + dx[d];
            y = y + dy[d];
        }
        
        //1차원 배열에 순서 저장
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = pyramid[i][j];
            }
        }
        return answer;
    }
}