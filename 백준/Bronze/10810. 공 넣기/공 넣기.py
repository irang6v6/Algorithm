N,M = map(int,input().split())
args = [0] * N 
for l in range (M):
    i,j,k = map(int,input().split())
    for o in range(i-1,j):
        args[o] = k

for i in args:
    print(i,end=' ')