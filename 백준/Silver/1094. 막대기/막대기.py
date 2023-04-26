
import sys
input = sys.stdin.readline  # BufferedReader br =
# 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0) 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)

X = int(input())
a = 64
answer = 0
while X > 1:
    answer += X % 2
    X = X // 2
answer += X
print(answer)
