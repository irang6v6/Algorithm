import sys
input = sys.stdin.readline

N = int(input())
answer = ""

for i in range(1,N+1):
    A,B = map(int,input().split())
    print(A + B)
