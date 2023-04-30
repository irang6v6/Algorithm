args = []
for i in range(9):
    args.append(int(input()))
print(max(args),args.index(max(args))+1,sep='\n')