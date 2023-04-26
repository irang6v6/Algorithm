
import sys
input = sys.stdin.readline  # BufferedReader br =
# 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0) 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)

A, B = map(int, input().split())
C = int(input())

if (B + C) >= 60:
    A += (B + C)//60
print(A % 24, (B+C) % 60)
