package Programmers;

import java.util.Stack;

public class P64061 {
	//스택만 사용
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				
				//0일때 (빈 자리일때)
				if (board[j][moves[i] - 1] == 0)
					continue;
				//인형이 있는데 스택의 top과 일치하지 않거나 스택이 비어있을때
				else if (board[j][moves[i] - 1] != 0 && stack.isEmpty() || stack.peek() != board[j][moves[i] - 1]) {
					{
						stack.push(board[j][moves[i] - 1]);
						board[j][moves[i] - 1] = 0;
						break;
					}
				}
				//인형이 있고 스택의 top과 같은 인형일때 top을 pop하고 카운트를 2회 더해준다.
				else if (board[j][moves[i] - 1] != 0 && stack.peek() == board[j][moves[i] - 1]) {
					stack.pop();
					board[j][moves[i] - 1] = 0;
					answer += 2;
					break;
				}
			}
		}
		return answer;
	}

//	public static void main(String[] args) {
//		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
//				{ 3, 5, 1, 3, 1 } };
//		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
//		System.out.println(solution(board, moves));
//	}
}