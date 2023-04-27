import sys
input = sys.stdin.readline

X = int(input())
N = int(input())
price = 0

for i in range(1,N+1):
    A,B = map(int,input().split())
    price += (A * B)

if price == X :
    print("Yes")
else :
    print("No")
