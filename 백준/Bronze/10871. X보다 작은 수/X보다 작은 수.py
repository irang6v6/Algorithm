N, X = map(int,input().split())
args = input().split()

for i in args :
    if int(i) < X :
        print(i,end=' ')