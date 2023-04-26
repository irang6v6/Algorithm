def main():
    A = int(input())
    B = int(input())
    print(A * (B % 10))
    print(A * int((B / 10) % 10))
    print(A * int(B / 100))
    print(A * B)
 
if __name__=="__main__":
    main()