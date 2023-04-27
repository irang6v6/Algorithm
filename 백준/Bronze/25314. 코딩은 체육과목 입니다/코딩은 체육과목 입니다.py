import sys
input = sys.stdin.readline

N = int(input())
answer = ""

for i in range(1,N//4+1):
    answer += "long "

print(answer+"int")
