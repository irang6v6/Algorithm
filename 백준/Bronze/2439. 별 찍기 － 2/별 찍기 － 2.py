import sys
input = sys.stdin.readline

N = int(input())
answer = ""

for i in range(1,N+1):
    sys.stdout.write(" "*(N-i)+"*"*i+"\n")
