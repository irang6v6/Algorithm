N, X = map(int,input().split())
args = list(map(int,input().split()))
for i in range(N) :
    if args[i] < X :
        print(args[i],end=' ')