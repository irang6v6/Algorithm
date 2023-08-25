import math

class Solution:
    def countPrimes(self, n: int) -> int:
        arr = [1] * n
        
        if n < 2:
            return 0
        else:
            arr[0], arr[1] = 0, 0
            
        for i in range(2,n):
            if arr[i] == 1:
                j = 2
                while i * j < n:
                    arr[i * j] = 0
                    j += 1
        return sum(arr)
                    