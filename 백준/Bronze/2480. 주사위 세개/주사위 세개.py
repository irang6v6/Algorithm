
import sys
input = sys.stdin.readline  # BufferedReader br =

A, B, C = map(int, input().split())

if A == B and B == C :
    print(10000 + A * 1000)
elif A != B and B != C and A != C :
    print(max(A,B,C) * 100)
else :
    if A == B :
        print ( 1000 + A * 100)
    elif B == C :
        print ( 1000 + B * 100)
    else :
        print ( 1000 + C * 100)

