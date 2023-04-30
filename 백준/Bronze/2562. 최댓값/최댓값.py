args = [int(input()) for i in range(9)]
print(max(args),args.index(max(args))+1,sep='\n')