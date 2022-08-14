package Programmers;

public class P1829 {
    static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
	static int numberOfArea, maxSizeOfOneArea, count;

	public int[] solution(int m, int n, int[][] picture) {
		numberOfArea = 0;
		maxSizeOfOneArea = 0;
        count=0;
        
		boolean[][] isVisited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && isVisited[i][j] == false) {
					numberOfArea++;
                   // System.out.println(numberOfArea);
					find(i, j, picture, isVisited);
				}
				maxSizeOfOneArea = count > maxSizeOfOneArea ? count : maxSizeOfOneArea;
				count = 0;
			}
		}
        
        int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
        
		return answer;
	}

	private void find(int i, int j, int[][] picture, boolean[][] isVisited) {
		if (isVisited[i][j]) {
			return;
		}

		isVisited[i][j] = true;
		count++;

		for (int d = 0; d < 4; d++) {
			int nextX = i + dx[d];
			int nextY = j + dy[d];

			if (nextX < 0 || nextX >= picture.length || nextY < 0 || nextY >= picture[0].length)
				continue;

			if (picture[i][j] == picture[nextX][nextY] && !isVisited[nextX][nextY]) {
				find(nextX, nextY, picture, isVisited);
			}
		}
	}
}