import math

class Solution:
    def countPrimes(self, n: int) -> int:
        answer = 0
        arr = [True]*n
        for i in range(2,n):
            if arr[i] == True:
                answer += 1
                j = 2
                while i * j < n:
                    arr[i * j] = False
                    j += 1
        return answer
                    