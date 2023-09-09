class Solution:
    def minimumTotal(self, triangle):
        if not triangle:
            return 0

        answer = [0] * len(triangle)
        answer[0] = triangle[0][0]

        for i in range(1, len(triangle)):
            for j in range(len(triangle[i]) - 1, -1, -1):
                curr = min(answer[j] if j < len(triangle[i]) - 1 else float('inf'),
                           answer[j - 1] if j >= 1 else float('inf')) + triangle[i][j]
                answer[j] = curr

        min_sum = min(answer)
        return min_sum
