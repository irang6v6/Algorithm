import sys
input = sys.stdin.readline

def main():
    a,b = map(int,input().split())
    print(a+b,a-b,a*b,int(a/b),a%b,sep='\n')

if __name__=="__main__":
    main()