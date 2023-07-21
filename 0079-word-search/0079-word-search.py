class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(i, j, count):
            # 단어를 찾은 경우
            if count == len(word):
                return True
            
            # 보드 범위를 벗어난 경우 또는 현재 셀의 문자가 단어와 다른 경우
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[count]:
                return False
            
            temp = board[i][j]  # 현재 위치의 문자 저장
            board[i][j] = '#'   # 이미 방문한 것으로 표시

            # 상하좌우 탐색
            found = dfs(i + 1, j, count + 1) or dfs(i - 1, j, count + 1) or dfs(i, j + 1, count + 1) or dfs(i, j - 1, count + 1)

            board[i][j] = temp  # 탐색 후 다시 원래 문자로 되돌림
            return found

        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0):
                    return True
        return False
